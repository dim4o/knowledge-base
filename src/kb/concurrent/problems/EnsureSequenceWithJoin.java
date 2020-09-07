package kb.concurrent.problems;

/**
 * Problem: There are three threads T1, T2, and T3? How do you ensure sequence
 * T1, T2, T3 in Java?
 */
public class EnsureSequenceWithJoin {

    public static void main(String args[]) throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + " is Started");

        Thread t1 = new Thread("T1") {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is Completed");
            }
        };

        Thread t2 = new Thread(
                () -> System.out.println(Thread.currentThread().getName() + " is Completed"), "T2");

        Thread t3 = new Thread(
                () -> System.out.println(Thread.currentThread().getName() + " is Completed"), "T3");

        t1.start();

        t1.join(); // waits until T1 die
        t2.start();

        t2.join(); // waits until T2 die
        t3.start();

        t3.join(); // waits until T3 die

        System.out.println(Thread.currentThread().getName() + " is Completed");

        // Output
        // main is Started
        // T1 is Completed
        // T2 is Completed
        // T3 is Completed
        // main is Completed
    }

}
