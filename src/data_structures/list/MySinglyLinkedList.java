package data_structures.list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Implementation of custom Singly Linked List data structure. Because of the
 * recursive nature of the Linked List this implementation uses a recursion as
 * match as possible.
 * 
 * @author dimcho.nedev
 *
 * @param <T>
 */
public class MySinglyLinkedList<T> implements List<T> {

    private final String NOT_SUPPORTED_MSG = "Not supported yet.";

    public Node head = null;

    int size = 0;

    private class Node {
        Node() {
        }

        Node(T value) {
            this.value = value;
        }

        private Node next;
        private T value;
    }

    public MySinglyLinkedList() {
        head = new Node();
    }

    @Override
    public boolean add(T e) {
        size = add(head, e);
        return true;
    }

    /**
     * Appends the specified element to the end of this list.
     * 
     * @param currNode the current {@link Node}
     * @param e        the value to add
     * @return the size of the list after adding the new value
     */
    private int add(Node currNode, T e) {
        if (currNode.next == null) {
            currNode.next = new Node(e);
            return 1;
        }

        return add(currNode.next, e) + 1;
    }

    @Override
    public void add(int index, T element) {
        add(head, 0, index, element);
    }

    // head -> 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6

    /**
     * 
     * @param currNode
     * @param currIndex
     * @param index
     * @param element
     */
    private void add(Node currNode, int currIndex, int index, T element) {
        if (currIndex == index) {
            Node tail = currNode.next;
            currNode.next = new Node(element);
            currNode.next.next = tail;
            size++;
            return;
        }
        add(currNode.next, currIndex + 1, index, element);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c)
            if (!add(element))
                return false;
        return c.size() != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        for (T element : c)
            add(index, element);
        return c.size() > 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return get(index, -1, head);
    }

    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index     index of the element to return
     * @param currIndex index of the current element
     * @param the       current {@link Node}
     * @return the element at the specified position in this list
     */
    private T get(int index, int currIndex, Node currNode) {
        if (currIndex == index)
            return currNode.value;
        return get(index, currIndex + 1, currNode.next);
    }

    @Override
    public boolean remove(Object o) {
        return removeByValueRecursively(o, head);
    }

    /**
     * Recursive implementation of the removal operation.
     * 
     * @param o        an element to remove
     * @param currNode the current {@link Node}
     * @return whether this list contained the specified element
     */
    public boolean removeByValueRecursively(Object o, Node currNode) {
        if (currNode == null)
            return false;

        if (currNode.next != null && currNode.next.value.equals(o)) {
            currNode.next = currNode.next.next;
            size--;
            return true;
        }

        return removeByValueRecursively(o, currNode.next);
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return removeByIndexRecursively(index, -1, head);
    }

    public T removeByIndexRecursively(int index, int currIndex, Node currNode) {
        if (currNode == null)
            return null;

        if (index - 1 == currIndex) {
            T returnValue = currNode.next.value;
            currNode.next = currNode.next.next;
            size--;
            return returnValue;
        }

        return removeByIndexRecursively(index, currIndex + 1, currNode.next);
    }

    @Override
    public boolean contains(Object o) {
        return contains(o, head.next);
    }

    /**
     * Recursive implementation of the "contains" operation.
     * 
     * @param o        element whose presence in this list is to be tested
     * @param currNode the current {@link Node}
     * @return whether this list contains the specified element
     */
    private boolean contains(Object o, Node currNode) {
        if (currNode == null)
            return false;
        if (currNode.value.equals(o))
            return true;

        return contains(o, currNode.next);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c)
            if (!contains(element))
                return false;
        return true;
    }

    @Override
    public int indexOf(Object o) {
        return findIndexOfRecursively(o, 0, head.next);
    }

    private int findIndexOfRecursively(Object o, int currIndex, Node currNode) {
        if (currNode == null)
            return -1;
        if (currNode.value.equals(o))
            return currIndex;

        return findIndexOfRecursively(o, currIndex + 1, currNode.next);
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        int currIndex = 0;
        for (T element : this) {
            if (element.equals(o))
                lastIndex = currIndex;
            currIndex++;
        }

        return lastIndex;
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return setRecursively(index, 0, element, head.next);
    }

    /**
     * TODO: Documentation
     * 
     * @param index
     * @param currIndex
     * @param element
     * @param currNode
     * @return
     */
    public T setRecursively(int index, int currIndex, T element, Node currNode) {
        if (currNode == null)
            return null;
        if (index == currIndex) {
            T returnValue = currNode.value;
            currNode.value = element;
            return returnValue;
        }
        return setRecursively(index, currIndex + 1, element, currNode.next);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException();
        if (toIndex > size)
            throw new IndexOutOfBoundsException();

        if (fromIndex > toIndex)
            throw new IllegalArgumentException();
        return subListRecursive(fromIndex, toIndex, 0, head.next);
    }

    // Recursive
    // TODO:
    public List<T> subListRecursive(int fromIndex, int toIndex, int currIndex, Node currNode) {
        if (currNode == null)
            return new MySinglyLinkedList<T>();

        if (currIndex >= fromIndex && currIndex < toIndex) {
            List<T> l = subListRecursive(fromIndex, toIndex, currIndex + 1, currNode.next);
            l.add(0, currNode.value);
            return l;
        }

        return subListRecursive(fromIndex, toIndex, currIndex + 1, currNode.next);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object obj : c) {
            List<Integer> idxsToRemove = new MySinglyLinkedList<>();
            for (int i = 0; i < size; i++)
                if (obj.equals(get(i)))
                    idxsToRemove.add(i);

            int rem = 0;
            for (Integer idx : idxsToRemove)
                remove(idx - rem++);
            idxsToRemove = null;
        }

        return false;
    }

    // TODO: do it n^2 time. Now it is ~n^3
    @Override
    public boolean retainAll(Collection<?> c) {
        int len = size;
        boolean modification = false;
        for (int i = 0; i < len; i++) {
            if (!c.contains(get(i))) {
                remove(i--);
                len--;
                modification = true;
            }
        }

        return modification;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++)
            result[i] = get(i);
        return result;
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
    public void clear() {
        head.next = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    public class Itr implements Iterator<T> {
        private int currIdx = 0;
        private Node dummyHead = head;
        private Node prev = head;

        @Override
        public boolean hasNext() {
            return currIdx < size;
        }

        @Override
        public T next() {
            prev = dummyHead;
            dummyHead = dummyHead.next;
            T next = (T) dummyHead.value;
            currIdx++;
            return next;
        }
        
        @Override
        public void remove() {
            // TODO: implement it!
            prev.next = prev.next.next;
            size--;
        }
        
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof List))
            return false;
        @SuppressWarnings("unchecked")
        final List<T> l1 = (List<T>) obj;
        if (size != l1.size()) {
            return false;
        }
        Iterator<T> itr0 = iterator();
        Iterator<T> itr1 = l1.iterator();
        while (itr0.hasNext()) {
            if (!itr0.next().equals(itr1.next()))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        MySinglyLinkedList<Integer> l = new MySinglyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);

        l.add(3, 8);

        for (int i = 0; i < 8; i++) {
            System.out.println(l.get(i));
        }

        System.out.println(l);
        System.out.println(l.head);
        System.out.println(l.size);

        for (Integer el : l) {
            System.out.println(el);
        }
        
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.removeAll(List.of(1, 2, 3));
    }

//    @Override
//    public String toString() {
//        head = head.next;
//        while (head != null) {
//            System.out.println(head.value);
//            head = head.next;
//        }
//        
//        return null;
//    }

    @SuppressWarnings("hiding")
    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MSG);
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MSG);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MSG);
    }

}
