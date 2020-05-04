
// Determine the maximum amount of money the thief can rob tonight without alerting the police.
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

// the first element of which denotes the maximum amount of money that can be robbed if root is not robbed,
//  while the second element signifies the maximum amount of money robbed if it is robbed.
class Solution {
    private int[] robSub(TreeNode root) {
        if (root == null)
            return new int[2];
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];
        res[0] = Integer.max(left[0], left[1]) + Integer.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Integer.max(res[0], res[1]);
    }
}

public class House_Robber_III_v3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] testset = { { "3", "2", "3", "null", "3", "null", "1" }, { "3", "4", "5", "1", "3", "null", "1" } };
        for (String[] test : testset) {
            TreeNode root = TreeUtils.buildTree(test);
            System.out.println(solution.rob(root));
        }
    }
}