package kb.data_structures.list.test.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import kb.data_structures.list.test.util.ListTestUtil;

public class AddTest extends ListTestUtil {

    public AddTest(Class<?> cl) {
        super(cl);
    }

    @Test
    public void addSingleElementToEmptyListTest() {
        List<Integer> myList = initList();
        final int prevSize = myList.size();
        final Integer element = 42;

        myList.add(element);
        
        Assert.assertEquals(prevSize + 1, myList.size());
        Assert.assertEquals(element, myList.get(myList.size() - 1));
    }

    @Test
    public void addSeveralElementsToEmptyListTest() {
        List<Integer> myList = initList();
        int prevSize = myList.size();
        final int[] elements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        for (Integer el : elements) {
            myList.add(el);
            Assert.assertEquals(++prevSize, myList.size());
            Assert.assertEquals(el, myList.get(myList.size() - 1));
        }
    }
    
    @Test
    public void addSingleElementToNonEmptyListTest() {
        List<Integer> myList = initList(1, 1, 2, 3, 5, 8, 13, 21, 34);
        final int prevSize = myList.size();
        final Integer element = 55;

        myList.add(element);

        Assert.assertEquals(prevSize + 1, myList.size());
        Assert.assertEquals(element, myList.get(myList.size() - 1));
    }

    @Test
    public void addSeveralElementsToNonEmptyListTest() {
        List<Integer> myList = initList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int prevSize = myList.size();
        final int[] elements = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        for (Integer el : elements) {
            myList.add(el);
            Assert.assertEquals(++prevSize, myList.size());
            Assert.assertEquals(el, myList.get(myList.size() - 1));
        }
    }

}
