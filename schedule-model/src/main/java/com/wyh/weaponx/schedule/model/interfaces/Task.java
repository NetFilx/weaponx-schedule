package com.wyh.weaponx.schedule.model.interfaces;

/**
 * 具体执行的task
 * Created By lianzhao on 2019/2/2
 */
public interface Task<P, R> {

    /**
     * 执行
     *
     * @param params 入参
     * @return R return type
     */
    R execute(P params);

}
