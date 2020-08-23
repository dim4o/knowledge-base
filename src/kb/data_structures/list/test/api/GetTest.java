package kb.data_structures.list.test.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import kb.data_structures.list.test.util.ListTestUtil;

public class GetTest extends ListTestUtil {

    public GetTest(Class<?> cl) {
        super(cl);
    }

    @Test
    public void getAllElementsTest() {
        List<Integer> myList = initList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        for (int i = 0; i < expected.length; i++)
            Assert.assertEquals(expected[0], myList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getByNegativeIndexTest() {
        List<Integer> myList = initList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        myList.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getByHighIndexTest() {
        List<Integer> myList = initList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        myList.get(myList.size());
    }

}
