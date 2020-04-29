import java.util.Stack;

// Definition for a binary tree node.
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int x) {
//         val = x;
//     }
// }

// https://leetcode.com/problems/maximum-binary-tree/discuss/106146/C%2B%2B-O(N)-solution
// monotonic stack
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;
        Stack<TreeNode> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode node = new TreeNode(nums[i]);
            while (!st.isEmpty() && node.val > st.peek().val) {
                node.left = st.pop();
            }

            if (!st.isEmpty())
                st.peek().right = node;
            st.add(node);
        }
        return st.firstElement();
    }
}

public class Maximum_Binary_Tree_v2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { {}, { 3, 2, 1, 6, 0, 5 } };
        for (int[] nums : testset) {
            TreeNode root = solution.constructMaximumBinaryTree(nums);
            TreeUtils.printTree(root);
        }
    }
}