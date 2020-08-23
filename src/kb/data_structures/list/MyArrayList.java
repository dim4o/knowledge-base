package kb.data_structures.list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Implementation of custom ArrayList data structure.
 * 
 * @author dimcho.nedev
 *
 * @param <T>
 */
public class MyArrayList<T> implements List<T> {
    private final String NOT_SUPPORTED_MSG = "Not supported yet.";

    private final int DEFAULT_CAPACITY = 4;

    private int size;

    private Object[] arr;

    public MyArrayList() {
        arr = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        arraycopy(arr, 0, array, 0, size);
        return array;
    }

    @Override
    public boolean add(T e) {
        ensureCapacity();
        arr[size++] = e;
        return true;
    }

    // 1, 2, 3, 4, 5, 6, 7
    // 7 - 2 = 5
    @Override
    public void add(int index, T element) {
        ensureCapacity();
        arraycopy(arr, index, arr, index + 1, size - index);
        size++;
        arr[index] = element;
    }

    private void ensureCapacity() {
        if (arr.length == size) {
            Object[] newArr = new Object[arr.length * 2];
            arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c)
            add(element);
        return c.size() > 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        for (T element : c)
            add(index, element);
        return c.size() > 0;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c)
            if (!contains(element))
                return false;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object obj : c) {
            MyArrayList<Integer> idxsToRemove = new MyArrayList<>();
            for (int i = 0; i < size; i++) {
                if (obj.equals(arr[i])) {
                    idxsToRemove.add(i);
                }
            }
            int rem = 0;
            for (int i = 0; i < idxsToRemove.size(); i++)
                remove(idxsToRemove.get(i) - rem++);
            idxsToRemove = null;
        }

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int len = size;
        boolean modification = false;
        for (int i = 0; i < len; i++) {
            if (!c.contains(arr[i])) {
                remove(i--);
                len--;
                modification = true;
            }
        }

        return modification;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            arr[i] = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        @SuppressWarnings("unchecked")
        T result = (T) arr[index];

        return result;
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        @SuppressWarnings("unchecked")
        T oldElement = (T) arr[index];

        arr[index] = element;

        return oldElement;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        @SuppressWarnings("unchecked")
        T prevElement = (T) arr[index];
        arraycopy(arr, index + 1, arr, index, size - index - 1);
        // 0, 1, 2, 3, 4, 5, 6, 7
        arr[size--] = null;
        return prevElement;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++)
            if (arr[i].equals(o))
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--)
            if (arr[i].equals(o))
                return i;
        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException();
        if (toIndex > size)
            throw new IndexOutOfBoundsException();

        if (fromIndex > toIndex)
            throw new IllegalArgumentException();

        List<T> sublist = new MyArrayList<>();
        for (int i = fromIndex; i < toIndex; i++)
            sublist.add((T) arr[i]);

        return sublist;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr<>();
    }

    /**
     * This is a simple Iterator implementation. Not pretend that it is the best and
     * most correct implementation but satisfies the List interface implementation.
     */
    private class Itr<E> implements Iterator<E> {
        private int currIdx = 0;

        @Override
        public boolean hasNext() {
            return currIdx < size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            return (E) arr[currIdx++];
        }

    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof List))
            return false;
        @SuppressWarnings("unchecked")
        final List<T> l1 = (List<T>) o;
        if (l1.size() != size)
            return false;
//        
//        for (int i = 0; i < size; i++) {
//            if (!get(i).equals(l1.get(i))) {
//                return false;
//            }
//        }
//        Iterator<T> itr0 = iterator();
//        Iterator<T> itr1 = l1.iterator();
//        while (itr0.hasNext()) {
//            if (!itr0.next().equals(itr1.next())) {
//                return false;
//            }
//        }

        return true;
    }

    private void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) {
        // Uses "System.arraycopy" for better performance because it is a native method
        System.arraycopy(src, srcPos, dest, destPos, length);
        // TODO: Add custom implementation
//        T[] srcArr = (T[]) src;
//        T[] destArr = (T[]) dest;
//        for (int i = 0; i < length; i++) {
//            destArr[destPos + length - i] = srcArr[srcPos + i]; 
//        }
    }

    /**
     * Unsupported bellow operations are not supported. The current implementation
     * does not claim to replace or compete with the standard Java implementation.
     */
    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MSG);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MSG);
    }

    @SuppressWarnings("hiding")
    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MSG);
    }

}
