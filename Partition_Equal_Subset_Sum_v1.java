// Given a non-empty array containing only positive integers,
//  find if the array can be partitioned into two subsets such that
//  the sum of elements in both subsets is equal.
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length <= 1)
            return false;

        int n = nums.length, sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1)
            return false;
        int[][] dp = new int[n + 1][sum / 2 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = Integer.max(dp[i - 1][j - nums[i - 1]] + nums[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                // System.out.printf("%d ", dp[i][j]);
            }
            // System.out.println();
            if (dp[i][sum / 2] == sum / 2)
                return true;
        }

        return false;
    }
}

public class Partition_Equal_Subset_Sum_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { { 2 }, { 1, 5, 11, 5 }, { 1, 2, 3 }, { 1, 2, 3, 5 } };
        for (int[] nums : testset) {
            System.out.println(solution.canPartition(nums));
        }
    }
}