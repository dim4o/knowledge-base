package kb.concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

class Counter implements Runnable {
    private static int count = 0;
    Lock lock = null;

    public Counter(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            // This is not atomic operation
            count++;
        } finally {
            lock.unlock();
        }
    }

    public static int getCount() {
        return count;
    }
}

public class ReentrantLockDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Lock lock = new ReentrantLock();
        final int numberOfThreads = 100;

        IntStream.range(0, numberOfThreads).forEach((i -> executor.execute(new Counter(lock))));

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        // The count should be equal of the number of threads: 100
        System.out.println(Counter.getCount()); 
    }

}
