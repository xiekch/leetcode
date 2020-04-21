
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private TreeNode buildTree(int[] preorder, int begin, int end) {
        if (begin >= end)
            return null;
        TreeNode root = new TreeNode(preorder[begin]);
        int i;
        for (i = begin; i < end; i++) {
            if (preorder[i] > root.val) {
                break;
            }
        }
        root.left = buildTree(preorder, begin + 1, i);
        root.right = buildTree(preorder, i, end);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length);
    }
}

public class Construct_Binary_Search_Tree_from_Preorder_Traversal {
    public static void preorderTraverse(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.println(root.val);
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] preorder = { 8, 5, 1, 7, 10, 12 };
        TreeNode root= sol.bstFromPreorder(preorder);
        preorderTraverse(root);
    }
}