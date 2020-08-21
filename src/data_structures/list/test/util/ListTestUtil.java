package data_structures.list.test.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import data_structures.list.MyArrayList;

@RunWith(value = Parameterized.class)
public class ListTestUtil {

    private Class<?> listClass = null;

    public ListTestUtil(Class<?> listClass) {
        this.listClass = listClass;
    }

    /**
     * @return a {@link Collection} with the types of the {@link List}
     *         implementations.
     */
    @Parameters
    public static Collection<Class<?>> getTypesData() {
        return List.of(ArrayList.class, MyArrayList.class);
    }

    public <T> List<Integer> initList(Object... elements) {
        return initList(Integer.class, elements);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> initList(Class<T> type, Object... elements) {
        List<T> myList = null;
        try {
            myList = (List<T>) listClass.getDeclaredConstructor().newInstance();
            for (Object el : elements)
                myList.add(type.cast(el));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myList;
    }

    @SuppressWarnings("unchecked")
    protected List<Integer> initListByRange(int start, int end) {
        List<Integer> list = null;
        try {
            list = (List<Integer>) listClass.getDeclaredConstructor().newInstance();
            for (Integer i = start; i <= end; i++)
                list.add(i);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return list;
    }

}
