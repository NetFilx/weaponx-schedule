package com.wyh.weaponx.schedule.model.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * job注解，用于进行job的配置
 * Created By lianzhao on 2019/2/2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Job {

    /**
     * 主节点任务code，唯一
     *
     * @return
     */
    String code() default "";

    /**
     * 调度的corn配置
     *
     * @return
     */
    String corn() default "";

    /**
     * 任务描述
     *
     * @return
     */
    String desc() default "";

    /**
     * 任务优先级，数字越小，级别越高
     *
     * @return
     */
    int priority() default 0;

    /**
     * task 分片的数量，默认为10;
     *
     * @return
     */
    int taskShardNum() default 10;
}
