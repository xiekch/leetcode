import java.util.HashMap;

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
    private HashMap<TreeNode, Integer> map;

    private int robSub(TreeNode root) {
        if (root == null)
            return 0;
        if (map.containsKey(root))
            return map.get(root);
        int val = 0;
        if (root.right != null) {
            val += robSub(root.right.left) + robSub(root.right.right);
        }
        if (root.left != null) {
            val += robSub(root.left.left) + robSub(root.left.right);
        }
        val = Integer.max(val + root.val, robSub(root.left) + robSub(root.right));
        map.put(root, val);
        return val;
    }

    public int rob(TreeNode root) {
        map = new HashMap<>();
        return robSub(root);
    }
}

public class House_Robber_III_v2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] testset = { { "3", "2", "3", "null", "3", "null", "1" }, { "3", "4", "5", "1", "3", "null", "1" } };
        for (String[] test : testset) {
            TreeNode root = TreeUtils.buildTree(test);
            System.out.println(solution.rob(root));
        }
    }
}