package kb.concurrent.synchronizers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Represents a that makes IO calls to slow service.
 */
class IOTask implements Runnable {
    private Semaphore semaphore;

    public IOTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            // System.out.println(semaphore.availablePermits());
            semaphore.acquire();

            System.out.println("Acquire: " + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("Release: " + Thread.currentThread().getName());

            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class SemaphoreDemo {
    public static void main(String[] args) {
        // We have a pool with 20 threads but because of slow service we have a
        // limitation of 3 available permits to connect to this service.
        ExecutorService executor = Executors.newFixedThreadPool(20);

        Semaphore semaphore = new Semaphore(3);

        IntStream.range(0, 100).forEach(i -> executor.execute(new IOTask(semaphore)));

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
