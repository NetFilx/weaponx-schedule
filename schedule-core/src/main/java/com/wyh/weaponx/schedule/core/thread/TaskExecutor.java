package com.wyh.weaponx.schedule.core.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.wyh.weaponx.schedule.common.config.TaskExecutorConfig;

import java.util.concurrent.*;

/**
 * 任务执行器，一个job对应一个
 * Created By lianzhao on 2019/2/2
 */
public class TaskExecutor {


    /**
     * 线程名称
     */
    private String threadNamePatten;

    /**
     * threadFactory
     */
    private ThreadFactory taskExecutorFactory;

    private ExecutorService executor;

    public TaskExecutor(String threadNamePatten) {
        taskExecutorFactory = new ThreadFactoryBuilder().setNameFormat(threadNamePatten)
                .build();
        this.threadNamePatten = threadNamePatten;
        executor = new ThreadPoolExecutor(TaskExecutorConfig.CORE_THREAD, TaskExecutorConfig.MAX_THREAD, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(TaskExecutorConfig.SIZE_QUEUE), taskExecutorFactory,
                new RejectPolicy());
    }

    public void execute(Runnable command) {
        executor.execute(command);
    }

    public <T> Future<?> submit(Callable<T> command) {
        return executor.submit(command);
    }

    /**
     * for GC
     */
    public void destroy() {

        if (taskExecutorFactory != null) {
            taskExecutorFactory = null;
        }

        if (executor != null) {
            executor = null;
        }
    }

    class RejectPolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            for (int i = 0; i < TaskExecutorConfig.RETRY_TIME; ++i) {
                boolean offer = executor.getQueue().offer(r);
                if (offer) {
                    return;
                }
            }
        }
    }

}
