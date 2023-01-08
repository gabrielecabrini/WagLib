package me.itswagpvp.waglib.redis.status;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author _ItsWagPvP
 * @since 1.1.4
 * Interface for getting information about the thread pool
 */
@SuppressWarnings("unused")
public class ThreadPoolStatus {

    private final ThreadPoolExecutor threadPoolExecutor;

    public ThreadPoolStatus(ExecutorService executorService) {
        this.threadPoolExecutor = (ThreadPoolExecutor) executorService;
    }

    public int getActiveCount() {
        return threadPoolExecutor.getActiveCount();
    }

    public int getCorePoolSize() {
        return threadPoolExecutor.getCorePoolSize();
    }

    public int getLargestPoolSize() {
        return threadPoolExecutor.getLargestPoolSize();
    }

    public int getMaximumPoolSize() {
        return threadPoolExecutor.getMaximumPoolSize();
    }

    public int getPoolSize() {
        return threadPoolExecutor.getPoolSize();
    }

    public int getQueueSize() {
        return threadPoolExecutor.getQueue().size();
    }

    public long getTaskCount() {
        return threadPoolExecutor.getTaskCount();
    }

    public long getCompletedTaskCount() {
        return threadPoolExecutor.getCompletedTaskCount();
    }

    public int getQueueRemainingCapacity() {
        return threadPoolExecutor.getQueue().remainingCapacity();
    }

    public boolean isShutdown() {
        return threadPoolExecutor.isShutdown();
    }

    public boolean isTerminated() {
        return threadPoolExecutor.isTerminated();
    }

    public boolean isTerminating() {
        return threadPoolExecutor.isTerminating();
    }

}
