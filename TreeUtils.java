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