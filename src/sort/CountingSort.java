package sort;

import java.util.Arrays;

import sort.api.Sortable;

public class CountingSort implements Sortable {
    /**
     * Counting sort algorithm. Works with non-negative numbers in a given range.
     * The algorithm is based on the prior knowledge that the input is in given
     * range. See good explanation here: https://youtu.be/7zuGmKfUt7s
     * 
     * Time complexity: `O(n + k)`, Space complexity: `O(n + k)`, where `n` is input
     * size and `k` is the range size.
     */
    @Override
    public int[] sort(int[] nums) {
        // Calculate the upper bound of the range. This calculation should not be a part
        // of the algorithm but for convenience is placed here.
        int upperBound = 0;
        for (int num : nums)
            if (num > -1)
                upperBound = Math.max(num, upperBound);
            else
                throw new UnsupportedOperationException("Negative numbers are not supported.");

        // create a count array
        int[] counts = new int[upperBound + 1];
        for (int num : nums)
            counts[num]++;
        // create a cumulative sum array from the count array
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        // create the output array
        int[] output = new int[nums.length];
        // for each number from the input:
        // - place it's count on the position `count - 1`.
        // - decrease the count with 1.
        for (int i = nums.length - 1; i >= 0; i--) {
            output[counts[nums[i]] - 1] = nums[i];
            counts[nums[i]]--;
        }

        return output;
    }

    public static void main(String[] args) {
        Sortable cSort = new CountingSort();

        int[] arr = { 1, 4, 1, 2, 7, 5, 2 };
        System.out.println(Arrays.toString(cSort.sort(arr)));

        int[] arr1 = { 9, 0, 1, 0, 0, 6, 5, 4, 1, 3, 3, 2, 0, 7, 9, 8 };

        System.out.println(Arrays.toString(cSort.sort(arr1)));

    }

}
