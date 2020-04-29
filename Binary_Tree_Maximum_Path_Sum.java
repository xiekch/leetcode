
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    private int ans;

    private int pathSum(TreeNode root) {
        if (root == null)
            return 0;
        int right = pathSum(root.right);
        int left = pathSum(root.left);
        // System.out.printf("%d %d %d\n", right, left, root.val);
        ans = Integer.max(ans, right + left + root.val);
        return Integer.max(Integer.max(right, left) + root.val, 0);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        ans = root.val;
        pathSum(root);
        return ans;
    }
}

public class Binary_Tree_Maximum_Path_Sum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] testset = { { "1", "2", "3" }, { "-10", "9", "20", "null", "null", "15", "7" }, { "-3" },
                { "1", "-2", "3" } };
        for (String[] test : testset) {
            TreeNode root = TreeUtils.buildTree(test);
            TreeUtils.printTree(root);
            System.out.println(sol.maxPathSum(root));
        }
    }
}