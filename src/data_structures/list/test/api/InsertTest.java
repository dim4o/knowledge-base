package data_structures.list.test.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import data_structures.list.test.util.ListTestUtil;

public class InsertTest extends ListTestUtil {

    public InsertTest(Class<?> cl) {
        super(cl);
    }

    private List<Integer> myList;
    private List<Integer> arrList;

    @Before
    public void doFirst() {
        myList = initList(1, 2, 3, 4);
        arrList = new ArrayList<>(List.of(1, 2, 3, 4));
    }

    @Test
    public void insertMiddleTest() {
        List<Integer> myList = initList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> expected = initList(1, 2, 3, 4, 100, 5, 6, 7, 8, 9);
        myList.add(4, 100);

        Assert.assertEquals(expected, myList);
    }

    @Test
    public void insertMultipleInTheMiddleTest() {
        for (int i = 100; i < 120; i++)
            insert(2, i);
    }

    @Test
    public void insertMultipleAtTheFrontTest() {
        for (int i = 100; i < 120; i++)
            insert(0, i);
    }

    @Test
    public void insertMultipleLastTest() {
        for (int i = 100; i < 120; i++)
            insert(0, myList.size() - 1);
    }

    @Test
    public void insertToEmptyListTest() {
        arrList = new ArrayList<>();
        myList = initList();

        for (int i = 0; i < 10; i++) {
            arrList.add(0, i);
            myList.add(0, i);
            Assert.assertEquals(arrList.size(), myList.size());
        }

        Assert.assertEquals(arrList, myList);
    }

    private void insert(int index, Integer element) {
        myList.add(index, element);
        arrList.add(index, element);

        Assert.assertEquals(arrList, myList);
    }

}
