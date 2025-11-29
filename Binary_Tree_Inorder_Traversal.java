import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;

        while (!st.empty() || node != null) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
            node = st.pop();
            // System.out.println(node.val);
            // System.out.println(st);
            res.add(node.val);
            node = node.right;
        }

        return res;
    }
}

public class Binary_Tree_Inorder_Traversal {

    public static void main(String[] args) throws Exception {

        String[][] testCases = { { "1", null, "2", "3" } };
        Solution sol = new Solution();
        for (String[] testCase : testCases) {
            TreeNode root = TreeUtils.buildTree(testCase);
            TreeUtils.printTree(root);
            System.out.println(sol.inorderTraversal(root));
        }
    }
}