package interview.data_structures.list.test.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import interview.data_structures.list.test.util.TestUtil;

public class RemoveAllTest extends TestUtil {
    @Test
    public void removeAllFromTheMiddleTest() {
        List<Integer> myList = initList(1, 2, 3, 2, 3, 3, 4);
        List<Integer> expected = initList(1, 4);
        
        myList.removeAll(initList(2, 3));
        
        Assert.assertEquals(expected, myList);
    }
    @Test
    public void removeAllFromTheHeadTest() {
        List<Integer> myList = initList(1, 2, 3, 2, 3, 3, 4);
        List<Integer> expected = initList(4);
        
        myList.removeAll(initList(1, 2, 3));
        
        Assert.assertEquals(expected, myList);
    }
    
    @Test
    public void removeAllFromTheTailTest() {
        List<Integer> myList = initList(1, 2, 3, 2, 3, 3, 4);
        List<Integer> expected = initList(1, 2);
        
        myList.removeAll(initList(3, 4));
        
        Assert.assertEquals(expected, myList);
    }
    
    @Test
    public void removeAllElementsTest() {
        List<Integer> myList = initList(1, 2, 3, 4, 5, 6);
        List<Integer> expected = initList();
        
        myList.removeAll(initList(1, 2, 3, 4, 5, 6));
        
        Assert.assertEquals(0, myList.size());
        Assert.assertEquals(expected, myList);
    }
    
}
