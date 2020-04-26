// Determine if you are able to reach the last index.
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0)
            return false;
        int maxlen = 0;
        for (int i = 0; maxlen < nums.length && maxlen >= i && i < nums.length; i++) {
            maxlen = Integer.max(maxlen, i + nums[i]);
        }
        return maxlen >= nums.length - 1;
    }
}

public class Jump_Game {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] testset = { { 2, 3, 1, 1, 4 }, { 3, 2, 1, 0, 4 }, { 2, 3, 1, 1, 0 } };
        for (int[] test : testset) {
            System.out.println(sol.canJump(test));
        }
    }
}