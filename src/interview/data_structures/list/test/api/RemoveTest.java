package interview.data_structures.list.test.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import interview.data_structures.list.test.util.TestUtil;

public class RemoveTest extends TestUtil {
    @Test
    public void removeMiddleElementByIndexTest() {
        List<Integer> myList = initList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = initList(1, 2, 3, 4, 5, 6, 7, 8, 10);

        Assert.assertEquals(Integer.valueOf(9), myList.remove(8));
        Assert.assertEquals(expected, myList);
    }
    
    @Test
    public void removeFirstElementByIndexTest() {
        List<Integer> myList = initList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = initList(2, 3, 4, 5, 6, 7, 8, 9, 10);

        Assert.assertEquals(Integer.valueOf(1), myList.remove(0));
        Assert.assertEquals(expected, myList);
    }
    
    @Test
    public void removeLastElementByIndexTest() {
        List<Integer> myList = initList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = initList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Assert.assertEquals(Integer.valueOf(10), myList.remove(myList.size() - 1));
        Assert.assertEquals(expected, myList);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFromEmptyTest() {
        List<Integer> myList = initList();
        myList.remove(10);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeByNegativeIndexTest() {
        List<Integer> myList = initList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        myList.remove(-1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeByHighTest() {
        List<Integer> myList = initList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        myList.remove(myList.size());
    }

}
