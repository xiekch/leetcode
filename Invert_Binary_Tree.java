
// Definition for a binary tree node.
// public class TreeNode {
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }
}

public class Invert_Binary_Tree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] testset = { { "4", "2", "7", "1", "3", "6", "9" }, { "-10", "9", "20", "null", "null", "15", "7" },
                { "-3" }, { "1", "-2", "3" } };
        for (String[] test : testset) {
            TreeNode root = TreeUtils.buildTree(test);
            TreeUtils.printTree(root);
            TreeUtils.printTree(sol.invertTree(root));
        }
    }
}