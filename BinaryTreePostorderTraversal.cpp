#include <vector>
using namespace std;
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
    vector<int> v;

  public:
    vector<int> postorderTraversal(TreeNode *root) {
        postorder(root);
        return v;
    }

    void postorder(TreeNode *node) {
        if (node == NULL)
            return;
        if (node->left)
            postorderTraversal(node->left);
        if (node->right)
            postorderTraversal(node->right);
        v.push_back(node->val);
    }
};