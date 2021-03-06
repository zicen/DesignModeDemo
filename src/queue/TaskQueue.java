package queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskQueue {
    private BlockingQueue<ITask> mTaskQueue;
    private TaskExecutor[] mTaskExecutors;
    //AtomicInteger类，它的incrementAndGet()方法会每次递增1
    private AtomicInteger mAtomicInteger = new AtomicInteger();

    public TaskQueue(int size) {
        mTaskQueue = new PriorityBlockingQueue<>();
        mTaskExecutors = new TaskExecutor[size];
    }

    public void start() {
        stop();
        for (int i = 0; i < mTaskExecutors.length; i++) {
            mTaskExecutors[i] = new TaskExecutor(mTaskQueue);
            mTaskExecutors[i].start();
        }
    }

    public void stop() {
        if (mTaskExecutors != null) {
            for (TaskExecutor executor : mTaskExecutors) {
                if (executor != null) executor.quit();
            }
        }
    }

    public <T extends ITask> int add(T task) {
        if (!mTaskQueue.contains(task)) {
            task.setSequence(mAtomicInteger.incrementAndGet());
            mTaskQueue.add(task);
        }
        return mTaskQueue.size();
    }
}
