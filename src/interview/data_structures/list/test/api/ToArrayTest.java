package interview.data_structures.list.test.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import interview.data_structures.list.test.util.ListTestUtil;

public class ToArrayTest extends ListTestUtil {

    public ToArrayTest(Class<?> cl) {
        super(cl);
    }

    @Test
    public void toArrayTest() {
        List<Integer> myList = initList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Object[] actual = myList.toArray();
        Assert.assertEquals(10, actual.length);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void toArrayEmptyListTest() {
        List<Integer> myList = initList();
        Integer[] expected = {};
        Object[] actual = myList.toArray();
        Assert.assertEquals(0, actual.length);
        Assert.assertArrayEquals(expected, actual);
    }

    // TODO: public <T> T[] toArray(T[] a)
}
