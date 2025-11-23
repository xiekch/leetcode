
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 2) {
                while (nums[right] == 2 && right > i) {
                    right--;
                }
                if (right != i) {
                    swap(nums, i, right);
                    right--;
                }
            }

            print(nums);
            if (nums[i] == 0) {
                while (nums[left] == 0 && left < i) {
                    left++;
                }
                if (left != i) {
                    swap(nums, i, left);
                    left++;
                }
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

public class Sort_Colors_v1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] testCases = { { 1, 2, 0 }, { 1, 0, 1, 2, 1 }, { 0, 0, 1, 0, 0 } };
        for (int[] testCase : testCases) {
            sol.sortColors(testCase);
            sol.print(testCase);
        }
    }
}