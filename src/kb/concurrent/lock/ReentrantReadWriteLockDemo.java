package kb.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

class SynchronizedHashMap<K, V> {
    private Map<K, V> map;
    private Lock readLock;
    private Lock writeLock;
    
    public SynchronizedHashMap() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        map = new HashMap<>();
        readLock = lock.readLock();
        writeLock = lock.writeLock();
    }

    public V put(K key, V value) {
        try {
             writeLock.lock();
            return map.put(key, value);
        } finally {
             writeLock.unlock();
        }
    }

    public V get(K key) {
        try {
             readLock.lock();
            return map.get(key);
        } finally {
             readLock.unlock();
        }
    }
    
    // the remaining map methods can be implemented in similar fashion

    public String toString() {
        return map.toString();
    }
}

public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedHashMap<Character, Integer> map = new SynchronizedHashMap<>();

        ExecutorService pool = Executors.newCachedThreadPool();

        IntStream.range('a', 'z' + 1).forEach(i -> pool.execute(() -> map.put((char) i, i - 'a')));
        IntStream.range(0, 50).forEach(
                i -> pool.execute(() -> System.out.print(map.get((char) (i % 26 + 'a')) + " ")));

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println();

        System.out.println(map);
    }
}
