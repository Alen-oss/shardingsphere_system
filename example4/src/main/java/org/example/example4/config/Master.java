package org.example.example4.config;

import java.lang.annotation.*;

/**
 * 用于标识方法执行走主库
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
@Documented
public @interface Master {
}
