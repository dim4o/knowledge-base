package interview.data_structures.list.test.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import interview.data_structures.list.test.util.TestUtil;

public class ContainsTest extends TestUtil {
    @Test
    public void containsAnElementTest() {
        List<Integer> myList = initList(1, 2, 3, 4, 5, 6, 7);
        
        Assert.assertFalse(myList.contains(-1));
        Assert.assertFalse(myList.contains(0));
        Assert.assertFalse(myList.contains(8));
        
        for (int i = 1; i <= myList.size(); i++) {
            Assert.assertTrue(myList.contains(i));
        }
    }
    
    @Test
    public void emptyListcontainsAnElementTest() {
        List<Integer> myList = initList();
        
        Assert.assertFalse(myList.contains(-1));
        Assert.assertFalse(myList.contains(0));
        Assert.assertFalse(myList.contains(8));
    }
}
