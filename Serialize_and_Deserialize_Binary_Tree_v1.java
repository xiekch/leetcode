import java.util.*;

// Definition for a binary tree node. 
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int x) {
//         val = x;
//     }
// }

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        Queue<TreeNode> qu = new LinkedList<>();
        ArrayList<String> nodes = new ArrayList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            TreeNode node = qu.poll();
            if (node == null) {
                nodes.add("null");
            } else {
                nodes.add(String.valueOf(node.val));
                qu.offer(node.left);
                qu.offer(node.right);
            }
        }

        while (nodes.get(nodes.size() - 1).equals("null")) {
            nodes.remove(nodes.size() - 1);
        }

        StringBuilder sb = new StringBuilder("[" + nodes.get(0));
        for (int i = 1; i < nodes.size(); i++) {
            sb.append("," + nodes.get(i));
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data == "" || data == "[]")
            return null;
        data = data.substring(1, data.length() - 1);
        String[] values = data.split(",");

        if (values.length == 0 || toNode(values[0]) == null)
            return null;

        TreeNode root = toNode(values[0]);
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        for (int i = 1; i < values.length && !qu.isEmpty();) {
            TreeNode node = qu.poll();
            TreeNode next = toNode(values[i]);
            if (next != null) {
                node.left = next;
                qu.add(next);
            }
            i++;
            if (i < values.length) {
                next = toNode(values[i]);
                if (next != null) {
                    node.right = next;
                    qu.add(next);
                }
            }
            i++;
        }
        return root;
    }

    private static TreeNode toNode(final String str) {
        if (str.length() == 0 || str.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(str));
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// [1,2,3,null,null,4,5]
// []
// [1,2]
public class Serialize_and_Deserialize_Binary_Tree_v1 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        String[] testset = { "[]", "[1,2]", "[1,2,3,null,null,4,5]", "[1,2,3,null,null,null,null]", "[1,null,2,3]",
                "[1,null,2,3,4,5]", "[5,1,4,null,null,3,6]", "[10,5,15,null,null,11,20,6,16]" };
        for (String data : testset) {
            TreeUtils.printTree(codec.deserialize(data));
            data = data.substring(1, data.length() - 1);
            String[] values = data.split(",");
            System.out.println(codec.serialize(TreeUtils.buildTree(values)));
        }
    }
}