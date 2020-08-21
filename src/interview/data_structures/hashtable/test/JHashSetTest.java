package interview.data_structures.hashtable.test;

import java.util.Arrays;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import interview.data_structures.hashtable.JHashSet;

public class JHashSetTest {

    @Test
    public void containsAllTestTest() {
        Set<Integer> mySet = new JHashSet<>();
        Set<Integer> subSet = new JHashSet<>();
        for (int i = 0; i < 100; i++)
            mySet.add(i);
        for (int i = 50; i < 150; i++) {
            mySet.add(i);
            subSet.add(i);
        }

        Assert.assertTrue(mySet.containsAll(subSet));
        Assert.assertFalse(subSet.containsAll(mySet));
    }

    @Test
    public void addAllTest() {
        Set<Integer> evenSet = initSet(0, 10, 2);
        Set<Integer> oddSet = initSet(1, 10, 2);
        Set<Integer> allSet = initSet(0, 10, 1);

        Assert.assertTrue(evenSet.addAll(oddSet));
        Assert.assertEquals(allSet, evenSet);
        Assert.assertFalse(allSet.addAll(oddSet));
        Assert.assertEquals(allSet, evenSet);
    }

    @Test
    public void retainAllTest() {
        Set<Integer> s1 = initSet(50, 150, 1);
        Set<Integer> s2 = initSet(0, 100, 1);
        Set<Integer> s3 = initSet(50, 100, 1);
        Set<Integer> s4 = initSet(150, 200, 1);

        Assert.assertTrue(s2.retainAll(s1));
        Assert.assertEquals(s2, s3);
        Assert.assertFalse(s2.retainAll(s3));
        Assert.assertEquals(s2, s3);
    }

    @Test
    public void removeAllTest() {
        Set<Integer> s1 = initSet(50, 150, 1);
        Set<Integer> s2 = initSet(0, 100, 1);
        Set<Integer> s3 = initSet(100, 150, 1);
        Set<Integer> s4 = initSet(150, 200, 1);

        Assert.assertTrue(s1.removeAll(s2));
        Assert.assertEquals(s1, s3);
        Assert.assertFalse(s1.removeAll(s4));
        Assert.assertEquals(s1, s3);
    }

    @Test
    public void toArrayTest() {
        Object[] arr = initSet(0, 10, 1).toArray();
        Object[] expected = new Object[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Arrays.sort(arr);
        Assert.assertArrayEquals(expected, arr);
    }

    private Set<Integer> initSet(int from, int to, int step) {
        Set<Integer> mySet = new JHashSet<>();
        for (int i = from; i < to; i += step)
            mySet.add(i);
        return mySet;
    }
}
