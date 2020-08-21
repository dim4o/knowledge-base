package interview.data_structures.hashtable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Custom {@link Set} implementation. Uses custom {@link Map} implementation
 * with dummy object as a value.
 *
 * @param <E> represents the type of the element of the set
 * 
 * @author dimcho.nedev
 */
public class JHashSet<E> implements Set<E> {
    private final String NOT_SUPPORTED_MSG = "Not supported yet.";
    private static final Object DUMMY_VAL = new Object();

    private Map<E, Object> map;

    public JHashSet() {
        map = new JHashTable<>();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] output = new Object[map.size()];
        int i = 0;
        for (Object obj : map.keySet())
            output[i++] = obj;
        return output;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MSG);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, DUMMY_VAL) != null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object key : c)
            if (!map.containsKey(key))
                return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean isChanged = false;
        for (E key : c)
            if (map.put(key, DUMMY_VAL) == null)
                isChanged = true;
        return isChanged;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isChanged = false;
        Set<Object> colSet = new JHashSet<>();
        for (Object o : c)
            colSet.add(o);

        for (E key : map.keySet()) {
            if (!colSet.contains(key)) {
                this.remove(key);
                isChanged = true;
            }
        }

        return isChanged;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isChanged = false;
        for (Object key : c)
            if (map.remove(key) != null)
                isChanged = true;
        return isChanged;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Set))
            return false;

        Set<?> set = (Set<?>) o;

        if (set.size() != JHashSet.this.size())
            return false;

        for (E key : map.keySet()) {
            if (!set.contains(key))
                return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
}
