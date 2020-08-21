package sort;

import sort.api.Sortable;

public class BinaryInsertionSort implements Sortable {
    /**
     * Binary Insertion Sort (Insertion Sort using Binary Search). 
     * O(n^2) time for the worst case(reversed order), but the number of comparisons are O(n.log(n))
     * time for average case.
     * O(1) space
     */
    @Override
    public int[] sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            // 1. Use custom method:
            int idxToInset = binarySearch(nums, 0, i, curr);
            // 2. Use library method:
            // int idxToInset = Arrays.binarySearch(nums, 0, i, curr);
            // idxToInset = idxToInset >= 0 ? idxToInset : Math.abs(idxToInset) - 1;

            for (int j = i; j > idxToInset; j--)
                nums[j] = nums[j - 1];
            nums[idxToInset] = curr;
        }

        return nums;
    }

    /**
     * @param from - inclusive
     * @param to   - exclusive
     * @return - index of the lower bound
     */
    private int binarySearch(int[] arr, int l, int r, int target) {
        if (l >= r)
            return r;

        int mid = (l + r - 1) / 2;
        if (arr[mid] == target)
            return mid;
        else if (target < arr[mid])
            return binarySearch(arr, l, mid, target);
        else
            return binarySearch(arr, mid + 1, r, target);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
