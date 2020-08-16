package interview.data_structures.list.test.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interview.data_structures.list.test.util.TestUtil;

public class RemoveFirstOccurrenceTest extends TestUtil {
    List<Integer> myList = null;
    List<Integer> arrList = null;

    @Before
    public void doBefore() {
        myList = initList(1, 2, 3, 3, 4, 5, 4, 6, 1);
        arrList = new ArrayList<>(List.of(1, 2, 3, 3, 4, 5, 4, 6, 1));
    }

    @Test
    public void removeExistingElementTest() {
        removeElementHelper(List.of(1, 2, 3));
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
