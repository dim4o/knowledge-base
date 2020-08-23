package kb.sort;

import kb.sort.api.Sortable;

public class BubbleSort implements Sortable {
    /**
     * Bubble Sort, not accepted (Time Limit Exceeded). 
     * Moreover the same time complexity as Insertion Sort or Selection Sort 
     * this algorithm seems slower in practice. 
     * O(n^2) time, O(1) space.
     */
    @Override
    public int[] sort(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    sorted = false;
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
            if (sorted)
                break;
        }

        return nums;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
