// Given an integer array nums, find the sum of the elements
//  between indices i and j (i ≤ j), inclusive.
// binary indexed tree
class NumArray {
    private int[] nums;
    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i, nums[i]);
        }
    }

    private void add(int i, int diff) {
        i++;
        while (i <= n) {
            tree[i] += diff;
            i += (i & -i);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        add(i, diff);
    }

    private int sum(int i) {
        i++;
        int ans = 0;
        while (i > 0) {
            ans += tree[i];
            i -= (i & -i);
        }
        return ans;
    }

    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); obj.update(i,val); int param_2 = obj.sumRange(i,j);
 */
public class Range_Sum_Query_Mutable {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0, 2));
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));
    }
}