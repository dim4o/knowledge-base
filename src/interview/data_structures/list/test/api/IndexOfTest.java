package interview.data_structures.list.test.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import interview.data_structures.list.test.util.TestUtil;

public class IndexOfTest extends TestUtil {
    
    List<Integer> myList = initList(0, 1, 2, 2, 1, 3, 4, 3, 3, 5, 6, 7, 7); 
    
    @Test
    public void indexOfExistingElement() {
        Assert.assertEquals(0, myList.indexOf((Integer)0));
        Assert.assertEquals(1, myList.indexOf((Integer)1));
        Assert.assertEquals(2, myList.indexOf((Integer)2));
        Assert.assertEquals(5, myList.indexOf((Integer)3));
        Assert.assertEquals(6, myList.indexOf((Integer)4));
        Assert.assertEquals(9, myList.indexOf((Integer)5));
        Assert.assertEquals(10, myList.indexOf((Integer)6));
        Assert.assertEquals(11, myList.indexOf((Integer)7));
    }
    
    @Test
    public void indexOfNonExistingElement() {
        Assert.assertEquals(-1, myList.indexOf((Integer)8));
        Assert.assertEquals(-1, myList.indexOf((Integer)(-1)));
    }
    
    @Test
    public void indexOfEmptyList() {
        List<Integer> myList = initList();
        Assert.assertEquals(-1, myList.indexOf((Integer)1));
        Assert.assertEquals(-1, myList.indexOf((Integer)8));
    }
}
