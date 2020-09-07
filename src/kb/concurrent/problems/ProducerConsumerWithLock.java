package kb.concurrent.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLock implements ProducerConsumer {

    private final int MAX_SIZE = 10;
    private final Random rand = new Random();
    Queue<Integer> queue = new LinkedList<>();

    ReentrantLock lock = new ReentrantLock();
    Condition isNotFull = lock.newCondition();
    Condition isNotEmpty = lock.newCondition();

    // Produce an item
    @Override
    public void produce() {
        try {
            lock.lock();

            while (queue.size() == MAX_SIZE) {
                System.out.println(Thread.currentThread().getName() + " -> waiting state.");
                isNotFull.await();
            }
            // produce an item and add to the queue
            int num = rand.nextInt(100);
            System.out.println(Thread.currentThread().getName() + "-> add: " + num);
            queue.add(num);

            isNotEmpty.signalAll();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // Consume an item
    @Override
    public void consume() {
        try {
            lock.lock();
            while (queue.size() == 0) {
                isNotEmpty.await();
            }
            // remove an item from the queue
            System.out.println(Thread.currentThread().getName() + "-> remove: " + queue.poll());

            isNotFull.signalAll();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ProducerConsumerWithLock pc = new ProducerConsumerWithLock();

        // Create producer threads
        for (int i = 0; i < 15; i++) {
            Thread th = new Thread(() -> pc.produce());
            th.setName("Producer " + i);
            th.start();
        }

        // Create consumer threads
        for (int i = 0; i < 10; i++) {
            Thread th = new Thread(() -> pc.consume());
            th.setName("Consumer " + i);
            th.start();
        }

        try {
            Thread.sleep(1000);

            System.out.println("Final queue size: " + pc.queue.size());
//            Thread.currentThread().join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
