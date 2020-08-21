package sort;

import sort.api.Sortable;

public class MergeSort implements Sortable {
    /**
     * Merge Sort. n.log(n) time for worst, average and base case. O(n) space, but
     * can be done and with O(1) space. Stable: Yes
     */
    @Override
    public int[] sort(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int[] mergeSort(int[] nums, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (lo == hi)
            return nums;

        nums = mergeSort(nums, lo, mid);
        nums = mergeSort(nums, mid + 1, hi);

        return merge(nums, lo, mid, hi);
    }

    /**
     * This is the tricky part of the algorithm.
     */
    private int[] merge(int[] nums, int lo, int mid, int hi) {
        int[] tmp = new int[hi - lo + 1];
        int l = lo, r = mid + 1;
        int i = 0;
        while (l <= mid && r <= hi)
            if (nums[l] < nums[r])
                tmp[i++] = nums[l++];
            else
                tmp[i++] = nums[r++];
        // copy the rest of the left part
        for (int j = l; j <= mid; j++)
            tmp[i++] = nums[j];
        // copy the rest of the right part
        for (int j = r; j <= hi; j++)
            tmp[i++] = nums[j];
        // copy the merged part to the original array
        for (int j = lo; j <= hi; j++)
            nums[j] = tmp[j - lo];

        return nums;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
