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
        int[] dp = new int[sum / 2 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = sum / 2; j >= 1; j--) {
                if (j >= nums[i - 1]) {
                    dp[j] = Integer.max(dp[j - nums[i - 1]] + nums[i - 1], dp[j]);
                }
            }
            if (dp[sum / 2] == sum / 2)
                return true;
        }

        return false;
    }
}

public class Partition_Equal_Subset_Sum_v2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { { 2 }, { 1, 5, 11, 5 }, { 1, 2, 3 }, { 1, 2, 3, 5 } };
        for (int[] nums : testset) {
            System.out.println(solution.canPartition(nums));
        }
    }
}