package kb.sort.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import kb.sort.BinaryInsertionSort;
import kb.sort.BubbleSort;
import kb.sort.BucketSort;
import kb.sort.CountingSort;
import kb.sort.HeapSort;
import kb.sort.InsertionSort;
import kb.sort.MergeSort;
import kb.sort.QuickSort;
import kb.sort.RadixSort;
import kb.sort.SelectionSort;
import kb.sort.api.Sortable;

@RunWith(value = Parameterized.class)
public class SortTest {
    private Class<?> sortClass = null;

    private Sortable algorithm;

    private boolean supportsNegative;

    public SortTest(Class<?> sortClass) {
        this.sortClass = sortClass;
    }

    @Before
    public void setUp() {
        try {
            algorithm = (Sortable) sortClass.getDeclaredConstructor().newInstance();
            Class<?> cl = algorithm.getClass();
            supportsNegative = !cl.equals(CountingSort.class) && !cl.equals(BucketSort.class)
                    && !cl.equals(RadixSort.class);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return a {@link Collection} with the types of the
     *         {@link kb.sort.api.Sortable} implementations.
     */
    @Parameters(name = "{index}: {0}")
    public static Collection<Class<?>> getTypesData() {
        return List.of(BinaryInsertionSort.class, BubbleSort.class, BucketSort.class,
                CountingSort.class, HeapSort.class, InsertionSort.class, MergeSort.class,
                QuickSort.class, RadixSort.class, SelectionSort.class);
    }

    @Test
    public void smallDataTest() {
        Assume.assumeTrue(supportsNegative);
        test(new int[] { 1, 5, 2, 3, 1, 0, 13, 19, -1, -5, 20 });
        test(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 });
        test(new int[] { -1, -2, -3, -4, -5, -6, -7, -8, -9, -10 });
        test(new int[] { -1, -1, -1, -1, 0, 0, 0, 0, 0, 1, 1, 1, 1 });
    }

    @Test
    public void randomDataTest() {
        Assume.assumeTrue(supportsNegative);
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int[] arr = new int[100];
            for (int idx = 0; idx < 100; idx++)
                arr[idx] = rand.nextInt();

            test(arr);
        }
    }

    @Test
    public void sortSmallPositiveNumbersTest() {
        Assume.assumeFalse(supportsNegative);
        test(new int[] {});
        test(new int[] { 0 });
        test(new int[] { 1, 4, 1, 2, 7, 5, 2 });
        test(new int[] { 9, 0, 1, 0, 0, 6, 5, 4, 1, 3, 3, 2, 0, 7, 9, 8 });
        test(new int[] { 1000, 500, 100, 200, 450, 850, 150, 300, 0, 8, 9 });
    }
    
    @Test
    public void sortRandomPositiveNumbersTest() {
        Assume.assumeFalse(supportsNegative);
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int[] arr = new int[100];
            for (int idx = 0; idx < 100; idx++)
                arr[idx] = rand.nextInt(10_000);

            test(arr);
        }
    }

//    @Test
//    public void bucketSortTest() {
//        Assume.assumeTrue(algorithm.getClass().equals(BucketSort.class));
//        Assert.assertEquals(0, 1);
//    }

//    @Test
//    public void radixSortTest() {
//        Assume.assumeTrue(algorithm.getClass().equals(RadixSort.class));
//        Assert.assertEquals(0, 1);
//    }

    private void test(int[] input) {
        int[] result = algorithm.sort(input);
        Arrays.sort(input);

        Assert.assertArrayEquals(input, result);
    }
}
