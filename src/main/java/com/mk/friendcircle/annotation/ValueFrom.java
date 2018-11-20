package com.mk.friendcircle.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>参数映射时用到的注解</p>
 * <p>用意是请求参数中某字段为null时, 可从注解配置的参数取值</p>
 * <p>有点类似于别名, 但又不同, 只有原原参数为null时才会从别名中取值</p>
 *
 * @author shisong02
 * @see com.meituan.shortcuts.config.AliasModelAttributeMethodProcessor
 * @since 2018-09-07
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValueFrom {

    /**
     * 参数名(别名)列表
     */
    String[] value();
}
