import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

public class Kth_Largest_Element_in_an_Array_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { { 3, 2, 1, 5, 6, 4 }, { 3, 2, 3, 1, 2, 4, 5, 5, 6 } };
        int[] ks = { 2, 4 };
        for (int i = 0; i < testset.length; i++) {
            System.out.println(solution.findKthLargest(testset[i], ks[i]));
        }
    }
}
