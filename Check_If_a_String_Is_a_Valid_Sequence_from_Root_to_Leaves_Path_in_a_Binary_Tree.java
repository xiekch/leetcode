class Solution {
    public boolean dfs(TreeNode root, int[] arr, int index) {
        if (root == null)
            return false;
        if (root.val != arr[index])
            return false;
        if (index == arr.length - 1 && root.right == null && root.left == null) {
            return true;
        }
        if (index >= arr.length - 1)
            return false;
        return dfs(root.left, arr, index + 1) || dfs(root.right, arr, index + 1);
    }

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }
}

public class Check_If_a_String_Is_a_Valid_Sequence_from_Root_to_Leaves_Path_in_a_Binary_Tree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] testTrees = { { "0", "1", "0", "0", "1", "0", "null", "null", "1", "0", "0" },
                { "0", "1", "0", "0", "1", "0", "null", "null", "1", "0", "0" },
                { "0", "1", "0", "0", "1", "0", "null", "null", "1", "0", "0" },
                { "8", "3", "null", "2", "1", "5", "4" } };
        int[][] testArrs = { { 0, 1, 0, 1 }, { 0, 0, 1 }, { 0, 1, 1 }, { 8 } };
        for (int i = 0; i < testTrees.length; i++) {
            TreeNode root = TreeUtils.buildTree(testTrees[i]);
            System.out.println(solution.isValidSequence(root, testArrs[i]));
        }
    }
}