package kb.concurrent.synchronizers;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DependentService implements Runnable {
    private CountDownLatch latch;
    private String serviceId;

    public DependentService(String serviceId, CountDownLatch latch) {
        this.latch = latch;
        this.serviceId = serviceId;
    }

    @Override
    public void run() {
        // Simulate some initialization logic e. g. Data Base connection
        System.out.println(serviceId + " is initialized.");

        latch.countDown();
        // Here the service may continue with other operation
    }

}

public class CountDownLatchDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // count the number of times {@link #countDown} must be invoked before threads
        // can pass through {@link #await}
        CountDownLatch latch = new CountDownLatch(3);

        executor.submit(new DependentService("Service_1", latch));
        executor.submit(new DependentService("Service_2", latch));
        executor.submit(new DependentService("Service_3", latch));

        // With `await()` we ensures that all services have been initialized.
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The code here will be executed after all services initialization.
        System.out.println("All dependent services are initialized.");
        
        executor.shutdown();
    }

}
