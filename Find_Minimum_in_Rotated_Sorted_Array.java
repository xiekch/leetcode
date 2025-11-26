class Solution {
    public int findMin(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // System.out.printf("%d %d", left, right);
            // System.out.println();
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}

public class Find_Minimum_in_Rotated_Sorted_Array {

    public static void main(String[] args) {
        int[][] testCases = { { 3, 4, 5, 1, 2 }, { 4, 5, 6, 7, 0, 1, 2 } };
        Solution sol = new Solution();
        for (int[] testCase : testCases) {
            System.out.println(sol.findMin(testCase));
        }
    }
}