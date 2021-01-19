#include <queue>
#include <vector>
using namespace std;

// Given a binary tree, return the level order traversal of
//  its nodes' values. (ie, from left to right, level by level).
/**
 * Definition for a binary tree node.
 */
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
    struct Node {
        TreeNode *treeNode;
        int level;
        Node(TreeNode *treeNode, int level)
            : treeNode(treeNode), level(level) {}
    };
  public:
    vector<vector<int>> levelOrder(TreeNode *root) {
        vector<vector<int>> ans;
        if (root == NULL)
            return ans;
        queue<Node> qu;
        Node node(root, 0);
        qu.push(node);
        while (!qu.empty()) {
            node = qu.front();
            qu.pop();
            while (node.level >= ans.size()) {
                ans.push_back(vector<int>());
            }
            ans[node.level].push_back(node.treeNode->val);
            if (node.treeNode->left != NULL) {
                qu.push(Node(node.treeNode->left, node.level + 1));
            }
            if (node.treeNode->right != NULL) {
                qu.push(Node(node.treeNode->right, node.level + 1));
            }
        }
        return ans;
    }
};

//     3
//    / \
//   9  20
//     /  \
//    15   7

// [
//   [3],
//   [9,20],
//   [15,7]
// ]
