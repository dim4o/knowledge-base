package kb.data_structures.tree;

public interface Tree<V> {
    public void insert(V value);
    public boolean search(V value);
    public void delete(V value);
}
