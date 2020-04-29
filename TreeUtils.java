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
        if (str.length() == 0 || str.toLowerCase() == "null") {
            return null;
        }
        return new TreeNode(Integer.valueOf(str));
    }

    public static TreeNode buildTree(String[] nums) {
        TreeNode root = toNode(nums[0]);
        if (nums.length == 0 || root == null)
            return null;

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
            next = toNode(nums[i]);
            if (i < nums.length && next != null) {
                node.right = next;
                qu.add(next);
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
}