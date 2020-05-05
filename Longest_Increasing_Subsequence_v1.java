import java.util.Arrays;

// 8 ms
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ans = 1;
        int[] length = new int[nums.length];
        int[] minimal = new int[nums.length];
        Arrays.fill(length, 1);
        minimal[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minimal[i] = Integer.min(nums[i], minimal[i - 1]);
            for (int j = i - 1; j >= 0 && nums[i] > minimal[j]; j--) {
                if (nums[i] > nums[j])
                    length[i] = Integer.max(length[i], length[j] + 1);
            }
            ans = Integer.max(ans, length[i]);
        }
        return ans;
    }
}

// [10,9,2,5,3,3,7,101,18] 4
public class Longest_Increasing_Subsequence_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { { 10, 9, 2, 5, 3, 3, 7, 101, 18 }, { 1, 2, 2, 3, 1, 2, 3, 3 }, { 2, 3, 1, 2 }, { 1 } };
        for (int[] nums : testset) {
            System.out.println(solution.lengthOfLIS(nums));
        }
    }
}