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

class Solution {
    private int rob(TreeNode root, boolean visit) {
        if (root == null)
            return 0;
        if (!visit) {
            return rob(root.left, true) + rob(root.right, true);
        }
        return Integer.max(rob(root.left, true) + rob(root.right, true),
                root.val + rob(root.left, false) + rob(root.right, false));
    }

    public int rob(TreeNode root) {
        return Integer.max(rob(root, false), rob(root, true));
    }
}

public class House_Robber_III_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] testset = { { "3", "2", "3", "null", "3", "null", "1" }, { "3", "4", "5", "1", "3", "null", "1" } };
        for (String[] test : testset) {
            TreeNode root = TreeUtils.buildTree(test);
            System.out.println(solution.rob(root));
        }
    }
}