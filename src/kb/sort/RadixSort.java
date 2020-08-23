package kb.sort;

import java.util.Arrays;

import kb.sort.api.Sortable;

public class RadixSort implements Sortable {

    @Override
    public int[] sort(int[] nums) {
        int max = 0;
        for (int num : nums)
            if (num > -1)
                max = Math.max(num, max);
            else
                throw new UnsupportedOperationException("Negative numbers are not supported.");

        for (int exp = 1; max / exp > 0; exp *= 10)
            nums = countSort(nums, exp);

        return nums;
    }

    public int[] countSort(int[] nums, int exp) {
        int[] counts = new int[10];
        for (int num : nums)
            counts[(num / exp) % 10]++;

        for (int i = 1; i < counts.length; i++)
            counts[i] += counts[i - 1];

        int[] output = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            output[counts[(nums[i] / exp) % 10] - 1] = nums[i];
            counts[(nums[i] / exp) % 10]--;
        }

        return output;
    }

    public static void main(String[] args) {
        Sortable rSort = new RadixSort();

        int[] arr = { 1, 4, 1, 2, 7, 5, 2 };
        System.out.println(Arrays.toString(rSort.sort(arr)));

        int[] arr1 = { 9, 10, 1, 0, 20, 6, 5, 4, 1, 3, 3, 2, 0, 7, 9, 8 };

        System.out.println(Arrays.toString(rSort.sort(arr1)));
    }

}
