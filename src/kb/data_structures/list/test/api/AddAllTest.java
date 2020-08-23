package kb.data_structures.list.test.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import kb.data_structures.list.test.util.ListTestUtil;

public class AddAllTest extends ListTestUtil {

    public AddAllTest(Class<?> cl) {
        super(cl);
    }

    private List<Integer> numbersToAdd = List.of(6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
    
    @Test
    public void addAllToNonEmptyList() {
        List<Integer> myList = initList(1, 2, 3, 4);
        List<Integer> arrList = new ArrayList<>(List.of(1, 2, 3, 4));
        
        Assert.assertEquals(arrList.addAll(numbersToAdd), myList.addAll(numbersToAdd));
        Assert.assertEquals(arrList, myList);
    }
    
    @Test
    public void addAllToEmptyList() {
        List<Integer> myList = initList();
        List<Integer> arrList = new ArrayList<>();
        
        Assert.assertEquals(arrList.addAll(numbersToAdd), myList.addAll(numbersToAdd));
        Assert.assertEquals(arrList, myList);
    }
    
    @Test
    public void addAllToEmptyCollection() {
        List<Integer> myList = initList(1, 2, 3);
        List<Integer> arrList = new ArrayList<>(List.of(1, 2, 3));
        
        Assert.assertEquals(arrList.addAll(new ArrayList<>()), myList.addAll(new ArrayList<>()));
        Assert.assertEquals(arrList, myList);
    }
}
