import java.util.Arrays;

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        boolean first = false;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                if (!first) {
                    first = true;
                    if (num > 1) {
                        return 1;
                    }
                }
                if (i + 1 < nums.length && nums[i + 1] > num + 1) {
                    return num + 1;
                }
            }
        }
        if (!first) {
            return 1;
        }
        return nums[nums.length - 1] + 1;
    }
}

public class First_Missing_Positive_v1 {

    public static void main(String[] args) {
        int[][] testCases = { { 1, 2, 0 }, { 3, 4, -1, 1 }, { 7, 8, 9, 11, 12 }, { -5 } };
        Solution sol = new Solution();
        for (int[] testCase : testCases) {
            System.out.println(sol.firstMissingPositive(testCase));
        }
    }
}