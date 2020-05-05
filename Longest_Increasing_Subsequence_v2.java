import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            // if index < 0, it is the first index that is bigger than num
            int index = Arrays.binarySearch(dp, 0, len, num);
            if (index < 0)
                index = -(index + 1);
            dp[index] = num;
            if (index == len)
                len++;
        }
        return len;
    }
}

// [10,9,2,5,3,3,7,101,18] 4
public class Longest_Increasing_Subsequence_v2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { { 10, 9, 2, 5, 3, 3, 7, 101, 18 }, { 1, 2, 2, 3, 1, 2, 3, 3 }, { 2, 3, 1, 2 }, { 1 } };
        for (int[] nums : testset) {
            System.out.println(solution.lengthOfLIS(nums));
        }
    }
}