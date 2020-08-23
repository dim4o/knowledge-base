package kb.sort;

import kb.sort.api.Sortable;

public class QuickSort implements Sortable {
    /*
     * Quick Sort. 
     * n.log(n) time for average and base case, O(n^2) for the worst case.
     * O(1) space
     * Stable: No
     */
    @Override
    public int[] sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi)
            return;
        int pivIndex = partition(nums, lo, hi);
        quickSort(nums, lo, pivIndex - 1);
        quickSort(nums, pivIndex + 1, hi);
    }

    /**
     * Partitions the input without an auxiliary array.
     */
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Uses additional memory for the auxiliary array.
     */
    @SuppressWarnings("unused")
    private int partitionVariant(int[] nums, int lo, int hi) {
        int[] tmp = new int[hi - lo + 1];
        int tail = tmp.length - 1;
        int head = 0;
        int piv = nums[lo];
        for (int i = lo + 1; i <= hi; i++)
            if (nums[i] < piv)
                tmp[head++] = nums[i];
            else
                tmp[tail--] = nums[i];

        tmp[head] = piv;
        // copy back the auxiliary array to the original
        for (int i = 0; i < tmp.length; i++)
            nums[lo + i] = tmp[i];

        return head + lo;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
