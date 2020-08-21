package data_structures.list.test.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import data_structures.list.test.util.ListTestUtil;

public class ContainsAllTest extends ListTestUtil {

    public ContainsAllTest(Class<?> cl) {
        super(cl);
    }

    private List<Integer> myList = initListByRange(0, 100);

    @Test
    public void containsAllSubListElementsTest() {
        List<Integer> sublist = initListByRange(50, 80);

        Assert.assertTrue(myList.containsAll(sublist));
    }

    @Test
    public void containsAllIntersectionTest() {
        List<Integer> myList = initListByRange(0, 100);
        List<Integer> sublist = initListByRange(80, 120);

        Assert.assertFalse(myList.containsAll(sublist));
    }

    @Test
    public void containsAllNoIntersectionTest() {
        List<Integer> sublistHi = initListByRange(101, 120);
        List<Integer> sublistLo = initListByRange(-20, -1);

        Assert.assertFalse(myList.containsAll(sublistHi));
        Assert.assertFalse(myList.containsAll(sublistLo));
    }

    @Test
    public void containsAllEmptyListTest() {
        List<Integer> list = initList();

        Assert.assertFalse(list.containsAll(List.of(1, 2, 3, 4, 5, 6)));
    }
}
