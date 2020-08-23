package kb.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kb.sort.api.Sortable;

public class BucketSort implements Sortable {

    @Override
    public int[] sort(int[] nums) {
        // find the max number
        int max = 0;
        for (int num : nums)
            if (num > -1)
                max = Math.max(num, max);
            else
                throw new UnsupportedOperationException("Negative numbers are not supported.");

        // initialize the buckets
        int n = nums.length;
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new ArrayList[n];
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new ArrayList<>();

        // add the input numbers the the bucket with hashing function. The hashing
        // function should guarantees that: 
        // if `num_i <= num_j` then `hash(num_i) <= hash(num_j)` where 0 <= and hash(num) < n
        for (int num : nums)
            buckets[(int) ((num * 0.1) / max * n)].add(num);

        // Sort each bucket
        for (List<Integer> bucket : buckets)
            insertionSort(bucket); // or Collections.sort(bucket)

        // put back the numbers to the input/new array
        int i = 0;
        for (List<Integer> bucket : buckets)
            for (int num : bucket)
                nums[i++] = num;

        return nums;
    }

    public void insertionSort(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            int curr = nums.get(i);
            int j = i - 1;
            while (j >= 0 && nums.get(j) > curr)
                nums.set(j + 1, nums.get(j--));
            nums.set(j + 1, curr);
        }
    }

    public static void main(String[] args) {
        Sortable bSort = new BucketSort();

        int[] arr = { 1, 4, 1, 2, 7, 5, 2 };
        System.out.println(Arrays.toString(bSort.sort(arr)));

        int[] arr1 = { 9, 10, 1, 0, 20, 6, 5, 4, 1, 3, 3, 2, 0, 7, 9, 8 };

        System.out.println(Arrays.toString(bSort.sort(arr1)));

    }

}
