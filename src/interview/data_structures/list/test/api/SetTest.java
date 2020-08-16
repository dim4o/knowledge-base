package interview.data_structures.list.test.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import interview.data_structures.list.test.util.TestUtil;

public class SetTest extends TestUtil {
    
    @Test
    public void setAllElementsTest() {
        for (Integer index = 0; index < 10; index++) {
            List<Integer> arrList = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
            List<Integer> myList = initListByRange(0, 9);
            
            Integer element = -1;
            Assert.assertEquals(myList.set(index, element), arrList.set(index, element));
            Assert.assertEquals(arrList, myList);
        }
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void setElementEmpryListTest() {
        initList().set(5, 10);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void setInvalidIndexTest() {
        initListByRange(0, 9).set(50, 10);
    }
}
