package interview.data_structures.list.test.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import interview.data_structures.list.test.util.ListTestUtil;

//@RunWith(value = Parameterized.class)
public class SubListTest extends ListTestUtil {

    public SubListTest(Class<?> cl) {
        super(cl);
    }

    private List<String> myList = initList(String.class, "a", "b", "c", "d", "e", "f", "g", "h", "i", "g", "k"); // initList("a", "b", "c", "d", "e", "f", "g", "h", "i", "g", "k");
    private List<String> arrList = new ArrayList<>(
            List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "g", "k"));
    
    @Test
    public void subListMiddleIntervalTest() {
        Assert.assertEquals(arrList.subList(3, 7), myList.subList(3, 7));
        Assert.assertEquals(arrList.subList(1, 10), myList.subList(1, 10));
        Assert.assertEquals(arrList.subList(5, 6), myList.subList(5, 6));
    }

    @Test
    public void subListFromStartTest() {
        Assert.assertEquals(arrList.subList(0, 5), myList.subList(0, 5));
        Assert.assertEquals(arrList.subList(0, 1), myList.subList(0, 1));
        Assert.assertEquals(arrList.subList(0, 10), myList.subList(0, 10));
    }

    @Test
    public void subListToEndTest() {
        Assert.assertEquals(arrList.subList(3, 11), myList.subList(3, 11));
        Assert.assertEquals(arrList.subList(10, 11), myList.subList(10, 11));
    }

    @Test
    public void subListWholeListTest() {
        Assert.assertEquals(arrList.subList(0, 11), myList.subList(0, 11));
    }
    
    @Test
    public void subListWhenStartEqualsEndTest() {
        Assert.assertEquals(arrList.subList(0, 0), myList.subList(0, 0));
        Assert.assertEquals(arrList.subList(5, 5), myList.subList(5, 5));
        Assert.assertEquals(arrList.subList(10, 10), myList.subList(10, 10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void subListUnorderedIdxTest() {
        myList.subList(8, 6);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void subListOutOfBoundsTest() {
        myList.subList(0, 12);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void subListNegativeFromTest() {
        myList.subList(-10, 100);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void subListNegativeToTest() {
        myList.subList(1, -8);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void subListNegativeFromAndToFromSmallerThanToTest() {
        myList.subList(-6, -2);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void subListNegativeFromAndToFromGreaterThanToTest() {
        myList.subList(-2, -6);
    }
    
}
