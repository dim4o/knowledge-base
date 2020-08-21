package data_structures.hashtable;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Simple and intuitive Hash Table data structure implementation. For simplicity
 * this Hash Table does not support `null` key.
 * 
 * @param <K> represents the type of the key
 * @param <V> represents the type of the value
 * 
 * @author dimcho.nedev
 */
public class JHashTable<K, V> implements Map<K, V> {
    private final double LOAD_FACTOR = 0.75;
    private final int INITIAL_CAPACITY = 16;

    private int capacity = INITIAL_CAPACITY;
    private int size = 0;
    private List<LinkedList<Pair>> buckets;

    /** An entry that keeps the key-value pair **/
    private final class Pair implements Map.Entry<K, V> {
        private K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    public JHashTable() {
        buckets = new ArrayList<>(INITIAL_CAPACITY);
        for (int i = 0; i < capacity; i++)
            buckets.add(new LinkedList<>());
    }

    @Override
    public V get(Object key) {
        List<Pair> pairsBucket = buckets.get(calcIndex(key));
        for (Pair pair : pairsBucket)
            if (pair.getKey().equals(key))
                return pair.getValue();
        return null;
    }

    /**
     * Calculates the bucket index for a specific key.
     */
    private int calcIndex(Object key) {
        // 0x7fffffff = 2147483647 = 2^31 - 1 = 0111 1111 1111 1111 1111 1111 1111 1111
        // hashCode() & 0x7fffffff will convert the negative values to positive
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    @Override
    public V put(K key, V value) {
        int index = calcIndex(key);
        V oldValue = null;
        List<Pair> bucket = buckets.get(index);
        for (Pair pair : bucket)
            if (pair.getKey().equals(key)) {
                oldValue = pair.setValue(value);
                break;
            }
        if (oldValue == null) {
            buckets.get(index).add(new Pair(key, value));
            size++;
        }

        // resize the HashTable if the size is greater than the load factor
        if ((float) size / capacity >= LOAD_FACTOR) {
            capacity *= 2;
            List<LinkedList<Pair>> newTable = new ArrayList<>(capacity);
            for (int i = 0; i < capacity; i++)
                newTable.add(new LinkedList<Pair>());
            for (List<Pair> pairs : buckets)
                for (Pair pair : pairs)
                    newTable.get(calcIndex(pair.getKey())).add(pair);
            buckets = newTable;
        }

        return oldValue;
    }

    @Override
    public V remove(Object key) {
        List<Pair> list = buckets.get(calcIndex(key));
        for (Pair pair : list)
            if (pair.getKey().equals(key)) {
                list.remove(pair);
                size--;
                return pair.getValue();
            }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return JHashTable.this.get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (List<Pair> bucket : buckets)
            for (Pair pair : bucket)
                if (pair.getValue().equals(value))
                    return true;
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        for (int i = 0; i < buckets.size(); i++)
            buckets.set(i, new LinkedList<>());
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet())
            JHashTable.this.put(entry.getKey(), entry.getValue());
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ValuesView();
        return values;
    }
    
    final class ValuesView extends AbstractCollection<V> {
        private final Iterator<V> itr;

        ValuesView() {
            Collection<V> values = new LinkedList<>();
            for (List<Pair> bucket : buckets)
                for (Pair pair : bucket)
                    values.add(pair.getValue());
            itr = values.iterator();
        }

        @Override
        public Iterator<V> iterator() {
            return new Iterator<V>() {
                @Override
                public boolean hasNext() {
                    return itr.hasNext();
                }

                @Override
                public V next() {
                    return itr.next();
                }
            };
        }

        @Override
        public int size() {
            return JHashTable.this.size();
        }
    }

    @Override
    public Set<K> keySet() {
        return new SetView();
    }

    /** A {@link Set} view class for the map keys. **/
    final class SetView extends AbstractSet<K> {
        private final Iterator<K> itr;

        SetView() {
            Collection<K> keys = new LinkedList<>();
            for (List<Pair> bucket : buckets)
                for (Pair pair : bucket)
                    keys.add(pair.getKey());
            itr = keys.iterator();
        }

        @Override
        public Iterator<K> iterator() {
            return new Iterator<K>() {
                public boolean hasNext() {
                    return itr.hasNext();
                }

                public K next() {
                    return itr.next();
                }
            };
        }

        @Override
        public int size() {
            return JHashTable.this.size();
        }
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntryView();
    }

    /** A {@link Set} view class for the map entries. **/
    private class EntryView extends AbstractSet<Map.Entry<K, V>> {
        private final Iterator<Map.Entry<K, V>> itr;

        EntryView() {
            List<Map.Entry<K, V>> keys = new LinkedList<>();
            for (List<Pair> bucket : buckets)
                for (Pair pair : bucket)
                    keys.add(pair);
            itr = keys.iterator();
        }

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Map.Entry<K, V>>() {
                public boolean hasNext() {
                    return itr.hasNext();
                }

                public Entry<K, V> next() {
                    return itr.next();
                }
            };
        }

        @Override
        public int size() {
            return this.size();
        }
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
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (List<Pair> bucket : buckets)
            for (Pair pair : bucket)
                sb.append(pair.getKey()).append("=").append(pair.getValue()).append(", ");
        if (sb.length() > 2)
            sb.delete(sb.length() - 2, sb.length());
        return sb.append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Map))
            return false;

        Map<?, ?> map = (Map<?, ?>) o;

        if (map.size() != JHashTable.this.size())
            return false;

        for (Map.Entry<K, V> pair : entrySet()) {
            K key = pair.getKey();
            V val = pair.getValue();
            if (!map.containsKey(key))
                return false;
            if (!map.get(key).equals(val))
                return false;
        }

        return true;
    }
}
