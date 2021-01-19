#include <iostream>
#include <stack>
using namespace std;
// Given a binary tree, flatten it to a linked list in-place.
// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
// inorder traversal
class Solution {
  public:
    void flatten(TreeNode *root) {
        if (root == NULL)
            return;
        stack<TreeNode *> st;
        st.push(root);
        TreeNode *prev = root;
        while (!st.empty()) {
            TreeNode *node = st.top();
            st.pop();
            if (node->right != NULL)
                st.push(node->right);
            if (node->left != NULL)
                st.push(node->left);
            prev->right = node;
            prev->left = NULL;
            prev = node;
        }
        prev->left = prev->right = NULL;
    }
};

int main(int argc, char const *argv[]) {
    TreeNode *root = new TreeNode(0);
    Solution sol;
    sol.flatten(root);
    return 0;
}
