#include <iostream>
using namespace std;
// https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java
// Given a non-empty binary tree, find the maximum path sum.
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
    int maxSum;
    // pathDown
    //  (1) computes the maximum path sum with highest node is the input node, 
    // update maximum if necessary (2) returns the maximum sum of the path that 
    // can be extended to input node's parent.
    int pathDown(TreeNode *node) {
        if (node == NULL)
            return 0;
        int ri = max(0, pathDown(node->right));
        int le = max(0, pathDown(node->left));
        maxSum = max(maxSum, ri + le + node->val);
        // return the sum of a path
        return max(ri, le) + node->val;
    }

  public:
    int maxPathSum(TreeNode *root) {
        if (root == NULL)
            return 0;
        else
            maxSum = root->val;
        pathDown(root);
        return maxSum;
    }
};

// Input: [-10,9,20,null,null,15,7]
//    -10
//    / \
//   9  20
//     /  \
//    15   7
// Output: 42
