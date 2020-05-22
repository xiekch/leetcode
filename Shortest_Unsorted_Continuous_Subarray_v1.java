import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (copy[i] != nums[i]) {
                start = i;
                break;
            }
        }
        for (int i = nums.length; i > 1; i--) {
            if (copy[i - 1] != nums[i - 1]) {
                end = i;
                break;
            }
        }
        return end - start;
    }
}

public class Shortest_Unsorted_Continuous_Subarray_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { {}, { 1 }, { 2, 1 }, { 1, 2 }, { 2, 6, 4, 8, 10, 9, 15 }, { 10, 8, 10, 9, 15, 7 } };
        for (int[] nums : testset) {
            System.out.println(solution.findUnsortedSubarray(nums));
        }
    }
}