class Solution {
    private int findLowerBound(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return (low == nums.length || nums[low] != target) ? -1 : low;
    }

    private int findUpperBound(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low - 1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        if (nums.length == 0)
            return ans;
        ans[0] = findLowerBound(nums, target);
        if (ans[0] == -1)
            return ans;
        ans[1] = findUpperBound(nums, target);

        return ans;
    }
}

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] numsset = { { 0, 1, 3, 3, 3, 3, 4, 5 }, { 5, 6, 7 }, { 1, 2, 3, 4, 6 }, {}, { 1 }, { 3, 3 } };
        int[] targets = { 3, 6, 5, 0, 0, 2 };
        for (int i = 0; i < numsset.length; i++) {
            int[] ans = sol.searchRange(numsset[i], targets[i]);
            System.out.printf("%d %d\n", ans[0], ans[1]);
        }
    }
}