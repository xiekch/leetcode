import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeUtils {
    private static TreeNode toNode(final String str) {
        if (str.length() == 0 || str.toLowerCase().equals("null")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(str));
    }

    public static TreeNode buildTree(String[] nums) {
        if (nums.length == 0 || toNode(nums[0]) == null)
            return null;
        TreeNode root = toNode(nums[0]);

        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        for (int i = 1; i < nums.length && !qu.isEmpty();) {
            TreeNode node = qu.poll();
            TreeNode next = toNode(nums[i]);
            if (next != null) {
                node.left = next;
                qu.add(next);
            }
            i++;
            if (i < nums.length) {
                next = toNode(nums[i]);
                if (next != null) {
                    node.right = next;
                    qu.add(next);
                }
            }
            i++;
        }

        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        boolean finished = false;
        while (!qu.isEmpty() && !finished) {
            finished = true;
            int levelNum = qu.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = qu.poll();
                if (node != null) {
                    finished = false;
                    System.out.printf("%d ", node.val);
                    qu.add(node.left);
                    qu.add(node.right);
                } else {
                    System.out.printf("*");
                    qu.add(null);
                    qu.add(null);
                }
            }
            System.out.printf("\n");
        }
    }

    public static TreeNode getNode(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        TreeNode left = getNode(root.left, val), right = getNode(root.right, val);
        if (left != null)
            return left;
        return right;
    }
}