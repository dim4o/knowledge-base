package interview.data_structures.list.test.util;

import java.util.List;

import interview.data_structures.list.MyArrayList;

public class TestUtil {

    protected <T> List<T> initList(T... elements) {
        List<T> list = new MyArrayList<>();
        for (T el : elements) {
            list.add(el);
        }

        return list;
    }
    
    protected List<Integer> initListByRange(int start, int end) {
        List<Integer> list = new MyArrayList<>();
        
        for (Integer i = start; i <= end; i++) {
            list.add(i);
        }
        
        return list;
    }
}
