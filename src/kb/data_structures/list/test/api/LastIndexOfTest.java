package kb.data_structures.list.test.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import kb.data_structures.list.test.util.ListTestUtil;

public class LastIndexOfTest extends ListTestUtil {

    public LastIndexOfTest(Class<?> cl) {
        super(cl);
    }

    List<Integer> myList = initList(0, 1, 2, 2, 1, 3, 4, 3, 3, 5, 6, 7, 7);

    @Test
    public void indexOfExistingElement() {
        Assert.assertEquals(0, myList.lastIndexOf((Integer) 0));
        Assert.assertEquals(4, myList.lastIndexOf((Integer) 1));
        Assert.assertEquals(3, myList.lastIndexOf((Integer) 2));
        Assert.assertEquals(8, myList.lastIndexOf((Integer) 3));
        Assert.assertEquals(6, myList.lastIndexOf((Integer) 4));
        Assert.assertEquals(9, myList.lastIndexOf((Integer) 5));
        Assert.assertEquals(10, myList.lastIndexOf((Integer) 6));
        Assert.assertEquals(12, myList.lastIndexOf((Integer) 7));
    }

    @Test
    public void indexOfNonExistingElement() {
        Assert.assertEquals(-1, myList.lastIndexOf((Integer) 8));
        Assert.assertEquals(-1, myList.lastIndexOf((Integer) (-1)));
    }

    @Test
    public void indexOfEmptyList() {
        List<Integer> myList = initList();
        Assert.assertEquals(-1, myList.lastIndexOf((Integer) 1));
        Assert.assertEquals(-1, myList.lastIndexOf((Integer) 8));
    }
}
