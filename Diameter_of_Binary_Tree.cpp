#include <iostream>
using namespace std;

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
    int diameter;
    int dfs(TreeNode *root) {
        if (root == NULL)
            return 0;
        int le = dfs(root->left), ri = dfs(root->right);
        diameter = max(diameter, le + ri);
        return max(le, ri) + 1;
    }

  public:
    int diameterOfBinaryTree(TreeNode *root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }
};
