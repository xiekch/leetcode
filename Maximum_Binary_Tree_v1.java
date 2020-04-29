// Definition for a binary tree node.
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int x) {
//         val = x;
//     }
// }

class Solution {
    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int id = start;
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > nums[id]) {
                id = i;
            }
        }
        TreeNode root = new TreeNode(nums[id]);
        root.left = constructMaximumBinaryTree(nums, start, id);
        root.right = constructMaximumBinaryTree(nums, id + 1, end);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }
}

public class Maximum_Binary_Tree_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { {}, { 3, 2, 1, 6, 0, 5 } };
        for (int[] nums : testset) {
            TreeNode root = solution.constructMaximumBinaryTree(nums);
            TreeUtils.printTree(root);
        }
    }
}