package interview.sort;

import interview.sort.api.Sortable;

public class InsertionSort implements Sortable {
    /**
     * Insertion sort. 
     * O(n^2) time, O(1) space.
     */
    @Override
    public int[] sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // Move elements of arr[0..i-1], that are
            // greater than curr, to one position ahead
            int j = i - 1;
            while (j >= 0 && nums[j] > curr)
                nums[j + 1] = nums[j--];

            nums[j + 1] = curr;
        }

        return nums;
    }

}
