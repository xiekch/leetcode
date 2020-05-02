// You must not modify the array (assume the array is read only).
// You must use only constant, O(1) extra space.
// Your runtime complexity should be less than O(n2).
// https://leetcode.com/problems/find-the-duplicate-number/solution/#approach-3-floyds-tortoise-and-hare-cycle-detection
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0)
            return 0;
        int tortoise = nums[0], hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return tortoise;
    }
}

public class Find_the_Duplicate_Number {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { { 1, 3, 4, 2, 2 }, { 3, 1, 3, 4, 2 }, { 1, 1, 2 }, { 2, 1, 1 } };
        for (int[] test : testset) {
            System.out.println(solution.findDuplicate(test));
        }
    }
}