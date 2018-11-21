package com.mk.friendcircle.config;

import com.mk.friendcircle.annotation.ValueFrom;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import javax.servlet.ServletRequest;
import java.lang.reflect.Field;

/**
 * 数据绑定, 当原始字段为空时，把别名的值绑定到原始字段上
 *
 * @author shisong
 * @see ValueFrom
 * @since 2018-09-07
 */
public class AliasDataBinder extends ExtendedServletRequestDataBinder {

    public AliasDataBinder(Object target, String objectName) {
        super(target, objectName);
    }

    @Override
    protected void addBindValues(MutablePropertyValues mpvs, ServletRequest request) {
        super.addBindValues(mpvs, request);
        // 处理要绑定参数的对象
        Class<?> targetClass = getTarget().getClass();
        // 获取对象的所有字段
        Field[] fields = targetClass.getDeclaredFields();
        // 处理所有字段
        for (Field field : fields) {
            // 原始字段上的注解
            ValueFrom valueFromAnnotation = field.getAnnotation(ValueFrom.class);
            // 若参数中包含原始字段或者字段没有别名注解, 则跳过该字段
            if (mpvs.contains(field.getName()) || valueFromAnnotation == null) {
                continue;
            }
            // 参数中没有原始字段且字段上有别名注解, 则依次取别名列表中的别名, 在参数中最先找到的别名的值赋值给原始字段
            for (String alias : valueFromAnnotation.value()) {
                // 若参数中包含该别名, 则把别名的值赋值给原始字段
                if (mpvs.contains(alias)) {
                    // 给原始字段赋值
                    mpvs.add(field.getName(), mpvs.getPropertyValue(alias).getValue());
                    // 跳出循环防止取其它别名
                    break;
                }
            }
        }
    }
}
