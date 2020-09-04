package kb.concurrent.synchronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {

    private CyclicBarrier barrier;
    private String taskId;

    public Task(String taskId, CyclicBarrier barrier) {
        this.taskId = taskId;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        int numOfCycles = 0;
        while (numOfCycles++ < 5) {
            try {
                System.out.println(taskId + " awaits the other tasks.");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println(taskId + " sending message ...");
            try {
                System.out.println(
                        String.format("---------- Cycle %s, %s ----------", numOfCycles, taskId));
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class CyclicBarrierDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        CyclicBarrier barrier = new CyclicBarrier(3);

        executor.submit(new Task("Task_1", barrier));
        executor.submit(new Task("Task_2", barrier));
        executor.submit(new Task("Task_3", barrier));

//        Thread.sleep(2000);

        executor.shutdown();

    }
}
