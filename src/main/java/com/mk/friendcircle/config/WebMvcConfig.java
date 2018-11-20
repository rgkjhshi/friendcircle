package com.mk.friendcircle.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 配置类, 等同于原来的web.xml
 *
 * @author song.shi
 * @since 2016-11-07
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean loginFilterProxy() {
        FilterRegistrationBean<DelegatingFilterProxy> filterRegistration = new FilterRegistrationBean<>();
        filterRegistration.setFilter(new DelegatingFilterProxy("loginFilter"));
        //  添加过滤参数. targetFilterLifecycle缺省为false, 表示生命周期由SpringApplicationContext管理, 设置为true则表示由ServletContainer管理
        filterRegistration.addInitParameter("targetFilterLifecycle", "true");
        filterRegistration.setEnabled(true);
        // 设置过滤路径(/* 表示所有路径)
        filterRegistration.addUrlPatterns("/user/*", "*.api", "*.htm");
        filterRegistration.setName("loginFilter");
        // 设置优先级
        filterRegistration.setOrder(1);
        return filterRegistration;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // 禁用根据后缀推测类型功能
        configurer.favorPathExtension(false);
    }

    /**
     * 添加HTTP消息转换器 httpMessageConverter
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        Gson gson = new GsonBuilder().serializeNulls()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(gson);
        converters.add(0, converter);
    }

    /**
     * 添加参数解析
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(processor());
    }

    @Bean
    protected AliasModelAttributeMethodProcessor processor() {
        return new AliasModelAttributeMethodProcessor(true);
    }

}
