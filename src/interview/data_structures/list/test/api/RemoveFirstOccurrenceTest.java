package interview.data_structures.list.test.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interview.data_structures.list.test.util.ListTestUtil;

public class RemoveFirstOccurrenceTest extends ListTestUtil {

    public RemoveFirstOccurrenceTest(Class<?> cl) {
        super(cl);
        // TODO Auto-generated constructor stub
    }

    List<Integer> myList = null;
    List<Integer> arrList = null;

    @Before
    public void doBefore() {
        myList = initList(1, 2, 3, 3, 4, 5, 4, 6, 1);
        arrList = new ArrayList<>(List.of(1, 2, 3, 3, 4, 5, 4, 6, 1));
    }

    @Test
    public void removeFromTheFrontTest() {
        removeElementHelper(List.of(1, 2, 3));
    }

    @Test
    public void removeFromTheFrontAndBackTest() {
        removeElementHelper(List.of(1, 1, 6, 4));
    }

    @Test
    public void removeFromTheMiddleTest() {
        removeElementHelper(List.of(4, 5));
    }

    @Test
    public void removeRepeatingElement1Test() {
        removeElementHelper(List.of(1, 1));
    }

    @Test
    public void removeRepeatingElement3Test() {
        removeElementHelper(List.of(3, 3));
    }

    @Test
    public void removeRepeatingElement4Test() {
        removeElementHelper(List.of(4, 4));
    }

    @Test
    public void removeNonExistingElementTest() {
        removeElementHelper(List.of(10, 20, 30));
    }

    @Test
    public void removeFromEmptyListTest() {
        myList = initList();
        arrList = new ArrayList<>();
        removeElementHelper(List.of(1, 2, 3));
    }

    private void removeElementHelper(List<Integer> numbers) {
        for (Integer num : numbers) {
            boolean isRemovedEx = arrList.remove((Integer) num);
            boolean isRemovedAc = myList.remove((Integer) num);
            Assert.assertEquals(arrList, myList);
            Assert.assertEquals(isRemovedEx, isRemovedAc);
        }
    }

}
