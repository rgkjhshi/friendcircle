package com.mk.friendcircle.aop;

import com.mk.friendcircle.annotation.ThreadRename;
import com.mk.friendcircle.util.SerialNumberUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 重命名线程名
 *
 * @author shisong02
 * @since 2018-08-30
 */
@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 10)
public class ThreadRenameAspect {

    private static final Logger logger = LoggerFactory.getLogger(ThreadRenameAspect.class);

    /**
     * 拦截类上的注解
     */
    @Pointcut(value = "@within(threadRename)", argNames = "threadRename")
    public void threadRenamePointcut(ThreadRename threadRename) {
    }

    @Around(value = "threadRenamePointcut(threadRename)")
    public Object threadRenameHandler(ProceedingJoinPoint joinPoint, ThreadRename threadRename) throws Throwable {
        String oldName = Thread.currentThread().getName();
        String newName = SerialNumberUtils.getSerialNumber("T");
        try {
            Thread.currentThread().setName(newName);
            return joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable e) {
            throw e;
        } finally {
            Thread.currentThread().setName(oldName);
        }
    }
}
