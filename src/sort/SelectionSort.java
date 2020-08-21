package sort;

import sort.api.Sortable;

public class SelectionSort implements Sortable {
    /**
     * Selection sort - initial intuitive solution. 
     * O(n^2) time , O(1) space.
     */
    @Override
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int curr = i;
            for (int j = i + 1; j < nums.length; j++)
                if (nums[j] < nums[curr])
                    curr = j;

            int tmp = nums[curr];
            nums[curr] = nums[i];
            nums[i] = tmp;
        }

        return nums;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
