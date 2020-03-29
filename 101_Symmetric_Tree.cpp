#include <iostream>

// Given a binary tree, check whether it is a mirror of itself 
//  (ie, symmetric around its center).
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
    bool isSymmetric(TreeNode *le, TreeNode *ri) {
        if (le == NULL || ri == NULL) {
            return le == NULL && ri == NULL;
        }

        return le->val == ri->val && isSymmetric(le->left, ri->right) &&
               isSymmetric(le->right, ri->left);
    }

  public:
    bool isSymmetric(TreeNode *root) {
        if (root == NULL)
            return true;
        return isSymmetric(root->left, root->right);
    }
};

//     1
//    / \
//   2   2
//    \   \
//    3    3
// false

//     1
//    / \
//   2   2
//    \  /
//    3 3
// true