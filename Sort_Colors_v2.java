
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right;) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
                // dont i++
                // nums[i] may be 0 after swapped
            } else {
                i++;
            }

            print(nums);
        }

    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void print(int[] nums) {
        for (int j = 0; j < nums.length; j++)
            System.out.print(nums[j]);
        System.out.println();
    }
}

public class Sort_Colors_v2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] testCases = { { 1, 2, 0 }, { 1, 0, 1, 2, 1 }, { 0, 0, 1, 0, 0 } };
        for (int[] testCase : testCases) {
            sol.sortColors(testCase);
            sol.print(testCase);
        }
    }
}