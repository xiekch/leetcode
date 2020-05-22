import java.util.Stack;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/solution/#approach-4-using-stack
// We need to determine the correct position of the minimum and the maximum element 
//  in the unsorted subarray to determine the boundaries of the required unsorted subarray.
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        Stack<Integer> st = new Stack<>();
        int left = nums.length, right = -1;
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                left = Integer.min(left, st.pop());
            }
            st.push(i);
        }
        st.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                right = Integer.max(right, st.pop());
            }
            st.push(i);
        }
        return right - left + 1 > 0 ? right - left + 1 : 0;
    }
}

public class Shortest_Unsorted_Continuous_Subarray_v2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { {}, { 1 }, { 2, 1 }, { 1, 2 }, { 2, 6, 4, 8, 10, 9, 15 }, { 10, 8, 10, 9, 15, 7 },
                { 2, 1, 10, 0, 3 } };
        for (int[] nums : testset) {
            System.out.println(solution.findUnsortedSubarray(nums));
        }
    }
}