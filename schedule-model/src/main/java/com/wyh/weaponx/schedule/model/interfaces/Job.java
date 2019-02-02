package com.wyh.weaponx.schedule.model.interfaces;

import java.util.List;

/**
 * job
 * Created By lianzhao on 2019/2/2
 */
public interface Job<P, R> {

    /**
     * 生成任务
     *
     * @param params
     * @return
     */
    List<R> selectTask(P params);

}
