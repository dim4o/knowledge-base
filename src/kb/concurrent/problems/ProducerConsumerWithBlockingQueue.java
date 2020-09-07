package kb.concurrent.problems;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This is the easiest Producer-Consumer problem solution. The Java
 * BlockingQueue is designed to solve this type of problems.
 */
public class ProducerConsumerWithBlockingQueue implements ProducerConsumer {

    private BlockingQueue<Integer> blockingQueue;

    private final Random rand = new Random();

    public ProducerConsumerWithBlockingQueue(int size) {
        blockingQueue = new LinkedBlockingQueue<>(size);
    }

    @Override
    public void produce() {
        try {
            blockingQueue.put(rand.nextInt());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void consume() {
        try {
            blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProducerConsumerWithBlockingQueue pc = new ProducerConsumerWithBlockingQueue(10);
        try {
            pc.blockingQueue.take();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
