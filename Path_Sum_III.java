import java.util.HashMap;

// The path does not need to start or end at the root or a leaf,
//  but it must go downwards. 
//  Definition for a binary tree node. 
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {
//     }

//     TreeNode(int val) {
//         this.val = val;
//     }

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

// https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method
// preSum is only valid in the same path
// `curSum` - `curSum-target` == `target`
class Solution {
    private int subPathSum(TreeNode root, int curSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null)
            return 0;
        curSum += root.val;
        int count = preSum.getOrDefault(curSum - target, 0);
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        count += subPathSum(root.left, curSum, target, preSum) + subPathSum(root.right, curSum, target, preSum);
        preSum.put(curSum, preSum.get(curSum) - 1);
        return count;
    }

    public int pathSum(TreeNode root, int target) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return subPathSum(root, 0, target, preSum);
    }
}

public class Path_Sum_III {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] testset = { { "10", "5", "-3", "3", "2", "null", "11", "3", "-2", "null", "1" },
                { "1", "null", "2", "null", "3", "null", "4", "null", "5" }, { "0", "1", "1" } };
        int[] sums = { 8, 3, 1 };
        for (int i = 0; i < testset.length; i++) {
            TreeNode root = TreeUtils.buildTree(testset[i]);
            System.out.println(solution.pathSum(root, sums[i]));
        }
    }
}