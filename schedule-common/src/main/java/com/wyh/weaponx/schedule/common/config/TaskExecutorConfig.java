package com.wyh.weaponx.schedule.common.config;

/**
 * 任务执行器配置
 * todo 可从配置文件读取
 * Created By lianzhao on 2019/2/2
 */
public class TaskExecutorConfig {

    public static final int CORE_THREAD = 100;

    public static final int MAX_THREAD = 150;

    public static final int SIZE_QUEUE = 1024;

    public static final int RETRY_TIME = 20;
}
