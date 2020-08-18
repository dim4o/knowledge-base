package interview.data_structures.list.test.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import interview.data_structures.list.test.util.ListTestUtil;

public class RetainAllTest extends ListTestUtil {

    public RetainAllTest(Class<?> cl) {
        super(cl);
    }

    private List<Integer> arrList = null;
    private List<Integer> myList = null;

    @Test
    public void retainAllTest() {
        for (int i = 0; i <= 9; i++)
            retainAllHelper(i);

        retainAllHelper();
        retainAllHelper(1, 2);
        retainAllHelper(1, 1, 2);
        retainAllHelper(3, 4);
        retainAllHelper(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    public void retainAllEmptryCollection() {
        Assert.assertEquals(new ArrayList<Integer>().retainAll(List.of(1, 2, 3)),
                initList().retainAll(List.of(1, 2, 3)));
    }

    public void retainAllHelper(Integer... indexes) {
        arrList = new ArrayList<>(List.of(1, 2, 2, 1, 3, 4, 5, 4, 6, 7, 7, 7, 8, 9));
        myList = initList(1, 2, 2, 1, 3, 4, 5, 4, 6, 7, 7, 7, 8, 9);

        Assert.assertEquals(arrList.retainAll(List.of(indexes)),
                myList.retainAll(List.of(indexes)));
        Assert.assertEquals(arrList, myList);
    }

}
