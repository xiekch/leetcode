import java.lang.Math;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] robbed = new int[n];
        robbed[0] = nums[0];
        int[] notRobbed = new int[n];
        for (int i = 1; i < n; i++) {
            robbed[i] = notRobbed[i - 1] + nums[i];
            notRobbed[i] = robbed[i - 1];
            if (i >= 2 && robbed[i - 2] > robbed[i - 1]) {
                notRobbed[i] = robbed[i - 2];
            }
        }
        return Math.max(robbed[n - 1], notRobbed[n - 1]);
    }
}

public class House_Robber_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { { 12, 7, 9, 13, 1 }, { 1, 2, 3, 1 }, { 2, 4, 4, 5, 10, 7, 2, 3, 4, 5 } };
        for (int[] test : testset) {
            System.out.println(solution.rob(test));
        }
    }
}