import java.lang.Math;
import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}

public class House_Robber_v2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { { 12, 7, 9, 13, 1 }, { 1, 2, 3, 1 }, { 2, 4, 4, 5, 10, 7, 2, 3, 4, 5 } };
        for (int[] test : testset) {
            System.out.println(solution.rob(test));
        }
    }
}