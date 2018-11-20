package com.mk.friendcircle.filter;

import com.google.gson.Gson;
import com.mk.friendcircle.enums.ExceptionEnum;
import com.mk.friendcircle.vo.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shisong02
 * @since 2018-08-30
 */
@Component
public class LoginFilter extends GenericFilterBean {
    private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    private static final Set<String> omitUrlSet = new HashSet<>();

//    @Resource
//    private UserTokenService userTokenService;

    static {
        omitUrlSet.add("/test/");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURL = httpServletRequest.getRequestURL().toString();
        for (String omitURL : omitUrlSet) {
            if (requestURL.contains(omitURL)) {
                logger.info(requestURL + "不需要登录, 直接放行");
                chain.doFilter(request, response);
                return;
            }
        }
        boolean isLogin = false;
        try {
            String userId = request.getParameter("userId");
            String token = request.getParameter("token");
            // 获取用户信息
//            long realUserId = userTokenService.getUserId(token);
//            isLogin = String.valueOf(realUserId).equals(userId);
        } catch (Exception e) {
            logger.error("从用户中心获取用户信息失败", e);
        }
        // 未登陆的情况
        if (!Boolean.TRUE.equals(isLogin)) {
            BaseResponse result = new BaseResponse(ExceptionEnum.BUSINESS_ERROR.getCode(), "用户未登录");
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().print(new Gson().toJson(result));
            return;
        }
        chain.doFilter(httpServletRequest, response);
    }
}
