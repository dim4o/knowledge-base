package interview.data_structures.hashtable.test;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import interview.data_structures.hashtable.JHashTable;

public class JHashTableTest {

    @Test
    public void putRandomDataTest() {
        Map<Integer, Character> actual = new JHashTable<>();
        Map<Integer, Character> expected = new HashMap<>();
        Random rnd = new Random();
        for (int i = 0; i < 256; i++) {
            int key = rnd.nextInt();
            char value = (char) (rnd.nextInt(26) + 'a');

            actual.put(key, value);
            expected.put(key, value);
        }

        Assert.assertEquals(expected, actual);
        // to test JHashTable equals() method
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getTest() {
        Map<Character, Integer> actual = new JHashTable<>();

        for (int i = 0; i < 26; i++) {
            char key = (char) ('a' + i);
            int value = i;
            actual.put(key, value);
        }

        for (Integer i = 0; i < 26; i++)
            Assert.assertEquals(i, actual.get((char) ('a' + i)));
    }

    @Test
    public void getRandomValueDataTest() {
        Map<Integer, String> actual = new JHashTable<>();
        Map<Integer, String> expected = new JHashTable<>();

        for (int i = 0; i < 555; i++) {
            String rndStr = genRandomString(7);
            actual.put(i, rndStr);
            expected.put(i, rndStr);
        }

        Assert.assertEquals(expected, actual);

        for (Integer i = 0; i < 555; i++)
            Assert.assertEquals(actual.get(i), expected.get(i));
    }

    public String genRandomString(int length) {
        Random rnd = new Random();
        byte[] array = new byte[rnd.nextInt(length)];
        rnd.nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

    @Test
    public void removeTest() {
        // map with 100 elements
        Map<Integer, Integer> myMap = new JHashTable<>();
        for (int i = 0; i < 100; i++)
            myMap.put(i, i * 2);
        int size = 100;

        // remove 25 elements(even numbers)
        for (int i = 0; i < 50; i += 2) {
            Assert.assertEquals(myMap.remove(i), Integer.valueOf(i * 2));
            Assert.assertEquals(--size, myMap.size());
        }

        Assert.assertEquals(75, myMap.size());
    }

    @Test
    public void containsKeyTest() {
        Map<Integer, String> myMap = new JHashTable<>();
        for (int i = 0; i < 100; i++)
            myMap.put(i, new String());

        for (int i = 0; i < 100; i++)
            Assert.assertTrue(myMap.get(i) != null);
    }

    @Test
    public void containsValueTest() {
        Map<Integer, Integer> myMap = new JHashTable<>();
        for (int i = 0; i < 100; i++)
            myMap.put(i, i * 5);

        for (int i = 0; i < 500; i += 5)
            Assert.assertTrue(myMap.containsValue(i));

        for (int i = 1; i < 500; i += 5)
            Assert.assertFalse(myMap.containsValue(i));
    }

    @Test
    public void clearTest() {
        Map<Integer, String> actual = new JHashTable<>();
        Map<Integer, String> expected = new JHashTable<>();
        for (int i = 0; i < 50; i++) {
            actual.put(i, new String());
            expected.put(i + 1, "test");
        }
        actual.clear();
        expected.clear();

        Assert.assertEquals(actual, expected);
        // to test JHashTable equals() method
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void putAllTest() {
        Map<Integer, Integer> actual = new HashMap<>();
        Map<Integer, Integer> map1 = new JHashTable<>();
        for (int i = 0; i < 50; i++) {
            map1.put(i, i * 2);
            actual.put(i, i * 2);
        }
        Map<Integer, Integer> map2 = new JHashTable<>();
        for (int i = 50; i < 100; i++) {
            map2.put(i, i * 2);
            actual.put(i, i * 2);
        }

        map1.putAll(map2);
        Assert.assertEquals(50, map2.size());
        map2.putAll(map1);

        Assert.assertEquals(100, map1.size());
        Assert.assertEquals(100, map2.size());
        Assert.assertEquals(map1, map2);
        Assert.assertEquals(map1, actual);
    }

    @Test
    public void keySetTest() {
        Map<Integer, String> myMap = new JHashTable<>();
        for (int i = 0; i < 50; i++)
            myMap.put(i, new String());
        Set<Integer> actual = myMap.keySet();

        for (int i = 0; i < 50; i++)
            Assert.assertTrue(actual.contains(i));
        for (int i = 50; i < 100; i++)
            Assert.assertFalse(actual.contains(i));
    }

    @Test
    public void valuesTest() {
        Map<Integer, Integer> myMap = new JHashTable<>();
        for (int i = 0; i < 50; i++)
            myMap.put(i, i * 2);
        for (int i = 25; i < 100; i++)
            myMap.put(i, i * 2);

        Collection<Integer> values = myMap.values();

        Assert.assertEquals(100, values.size());
        for (int i = 0; i < 100; i++)
            Assert.assertTrue(values.contains(i * 2));
    }

    @Test
    public void iterator() {
        Map<Integer, String> myMap = new JHashTable<>();
        for (int i = 0; i < 50; i++)
            myMap.put(i, new String());

        Integer i = 0;
        for (Map.Entry<Integer, String> entry : myMap.entrySet())
            Assert.assertEquals(i++, entry.getKey());
    }

}
