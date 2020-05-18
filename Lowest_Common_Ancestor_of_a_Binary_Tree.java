
// Definition for a binary tree node.
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int x) {
//         val = x;
//     }
// }

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right != null && left != null)
            return root;
        if (left != null)
            return left;
        return right;
    }
}

public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] testset = { { "3", "5", "1", "6", "2", "0", "8", "null", "null", "7", "4" },
                { "3", "5", "1", "6", "2", "0", "8", "null", "null", "7", "4" },
                { "3", "5", "1", "6", "2", "0", "8", "null", "null", "7", "4" },
                { "3", "5", "1", "6", "2", "0", "8", "null", "null", "7", "4" } };
        int[][] testNums = { { 5, 1 }, { 5, 4 }, { 7, 8 }, { 6, 4 } };
        for (int i = 0; i < testset.length; i++) {
            TreeNode root = TreeUtils.buildTree(testset[i]);
            TreeNode p = TreeUtils.getNode(root, testNums[i][0]), q = TreeUtils.getNode(root, testNums[i][1]);
            System.out.println(solution.lowestCommonAncestor(root, p, q).val);
        }
    }
}