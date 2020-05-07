// O(2^n)
class Solution {
    int ans;

    private void cal(int[] nums, int S, int curSum, int index) {
        if (index == nums.length) {
            if (curSum == S) {
                ans++;
            }
            return;
        }
        cal(nums, S, curSum + nums[index], index + 1);
        cal(nums, S, curSum - nums[index], index + 1);
    }

    public int findTargetSumWays(int[] nums, int S) {
        ans = 0;
        cal(nums, S, 0, 0);
        return ans;
    }
}

public class Target_Sum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] testset = { {}, { 1, 1, 1, 1, 1 }, { 1, 2, 3, 4 } };
        int[] sum = { 1, 3, 2 };
        for (int i = 0; i < testset.length; i++)
            System.out.println(sol.findTargetSumWays(testset[i], sum[i]));
    }
}   