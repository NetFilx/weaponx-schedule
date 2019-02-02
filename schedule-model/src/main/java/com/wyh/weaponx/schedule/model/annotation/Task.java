package com.wyh.weaponx.schedule.model.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * job下具体执行任务的task
 * Created By lianzhao on 2019/2/2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Task {

    String jobCode() default "";

}
