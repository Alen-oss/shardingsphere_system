package org.example.example4.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.example4.config.DynamicDataSource;
import org.example.example4.config.Master;
import org.example.example4.config.Slave;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 切面类：切点 + 通知
 */
@Component
@Aspect
public class DynamicDataSourceAspect {

    @Pointcut("execution(* org.example.example4.mapper.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        if (method.isAnnotationPresent(Master.class)) {
            // 切换数据源为主库
            DynamicDataSource.setDataSource("master");
        } else if (method.isAnnotationPresent(Slave.class)) {
            // 切换数据源为从库
            DynamicDataSource.setDataSource("slave");
        }
    }
}
