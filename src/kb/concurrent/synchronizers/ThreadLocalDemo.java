package kb.concurrent.synchronizers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ThreadSafeDateFormat {
    // With Java 8
    public static final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal
            .withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    // With Java version < 8 you have to override two methods
    public static final ThreadLocal<SimpleDateFormat> dateFormat1 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override
        public SimpleDateFormat get() {
            return super.get();
        }
    };
}

public class ThreadLocalDemo {
    private static Random rnd = new Random();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Date birthDate = getBirthDate(-1); // mock id
                    SimpleDateFormat currFormat = ThreadSafeDateFormat.dateFormat.get();
                    String bDate = currFormat.format(birthDate);

                    System.out.println(Thread.currentThread().getId() + ", "
                            + System.identityHashCode(currFormat) + ", " + bDate);
                }
            });
        }

        // The `SimpleDateFormat` instance is unique for each thread and the number of
        // the instances is equal of the number of the threads, so if a thread is reused
        // it will use the same instance of `SimpleDateFormat`:
        // ........................
        // 13, 1483065194, 1980-08-11
        // 19, 867811539, 2005-05-27
        // 14, 719291262, 1982-02-07
        // 12, 679685219, 1995-03-02
        // 14, 719291262, 1971-08-30
        // 12, 679685219, 2009-02-27
        // 14, 719291262, 2008-03-06
        // 12, 679685219, 1980-02-19
        // 19, 867811539, 1981-08-26
        // 12, 679685219, 2002-02-14
        // 19, 867811539, 2002-04-22
        // 12, 679685219, 1973-12-01
        // 19, 867811539, 1986-05-19
        // 12, 679685219, 2009-01-09
        // 17, 1762650100, 2007-05-28
        // ........................

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Returns some mock value
    @SuppressWarnings("deprecation")
    public static Date getBirthDate(int userId) {
        int year = rnd.nextInt(40) + 1970 - 1900;
        int month = rnd.nextInt(12);
        int day = rnd.nextInt(32);

        return new Date(year, month, day);
    }

}
