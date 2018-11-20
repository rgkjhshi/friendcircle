package com.mk.friendcircle.config;

import com.mk.friendcircle.annotation.ValueFrom;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

import javax.servlet.ServletRequest;

/**
 * 自定义的参数处理器, 处理被{@code ValueFrom}注解的参数
 *
 * @author shisong02
 * @see ValueFrom
 * @since 2018-09-07
 */
public class AliasModelAttributeMethodProcessor extends ServletModelAttributeMethodProcessor implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public AliasModelAttributeMethodProcessor(boolean annotationNotRequired) {
        super(annotationNotRequired);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
        AliasDataBinder aliasBinder = new AliasDataBinder(binder.getTarget(), binder.getObjectName());
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
        requestMappingHandlerAdapter.getWebBindingInitializer().initBinder(aliasBinder);
        aliasBinder.bind(request.getNativeRequest(ServletRequest.class));
    }
}
