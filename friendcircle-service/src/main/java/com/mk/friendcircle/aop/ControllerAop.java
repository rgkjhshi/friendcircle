package com.mk.friendcircle.aop;

import com.mk.friendcircle.enums.ExceptionEnum;
import com.mk.friendcircle.exception.BusinessException;
import com.mk.friendcircle.vo.BaseResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 用于组装最后返回结果
 *
 * @author song.shi
 * @since 2016-10-11
 */
@Aspect
@Component
public class ControllerAop {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    /**
     * 拦截返回结果为 BaseResponse 的所有controller
     */
    @Around("(execution(public com.mk.friendcircle.vo.BaseResponse com.mk.friendcircle.controller.*.*(..)))")
    public Object controllerHandler(ProceedingJoinPoint joinPoint) {
        String signature = joinPoint.getSignature().toShortString();
        BaseResponse response = new BaseResponse();
        try {
            response = (BaseResponse) joinPoint.proceed();
            if (response.getCode() == null) {
                response.setCode(ExceptionEnum.SUCCESS.getCode());
                response.setMessage(ExceptionEnum.SUCCESS.getMessage());
            }
        } catch (BusinessException e) {
            logger.error("{}{}", signature, e.getMessage());
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
        } catch (Throwable e) {
            logger.error("{}系统异常:{}", signature, e.getMessage(), e);
            response.setCode(ExceptionEnum.SYSTEM_ERROR.getCode());
            response.setMessage(ExceptionEnum.SYSTEM_ERROR.getMessage());
        }
        return response;
    }
}
