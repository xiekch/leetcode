
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int j = Math.abs(nums[i]);
            if (1 <= j && j <= n) {
                nums[j - 1] = -Math.abs(nums[j - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                // System.out.println(Arrays.toString(nums));
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}

public class First_Missing_Positive_v2 {

    public static void main(String[] args) {
        int[][] testCases = { { 1, 2, 0 }, { 3, 4, -1, 1 }, { 7, 8, 9, 11, 12 }, { -5 }, { 1 },
                { 100000, 3, 4000, 2, 15, 1, 99999 } };
        Solution sol = new Solution();
        for (int[] testCase : testCases) {
            System.out.println(sol.firstMissingPositive(testCase));
        }
    }
}