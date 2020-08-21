package sort;

import sort.api.Sortable;

public class HeapSort implements Sortable {
    /**
     * Heap Sort.
     * O(n.log(n)) time.
     * O(1) space.
     * Stable: No but can be made stable.
     */
    @Override
    public int[] sort(int[] arr) {
        // 1. First heapify the hole tree: every parent is grater than it's children
        for (int i = 2 * arr.length - 1; i >= 0; i--)
            heapify(arr, i, arr.length);
        // When the Max Heap is created he max value is the at the beginning of the array.
        // 2. Swap the first and the last element and decrease the heap size with 1.
        // 3. Call heapify to the reduced heap.
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
        
        return arr;
    }
    
    private void heapify(int[] arr, int start, int end) {
        int greater = start;
        int l = start * 2 + 1;
        int r = start * 2 + 2;
        if (l < end && r < end && arr[r] > arr[l] && arr[start] < arr[r])
            greater = r;
        else if (l < end && arr[start] < arr[l])
            greater = l;
        
        if (start != greater) {
            swap(arr, start, greater);
            heapify(arr, greater, end);
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
