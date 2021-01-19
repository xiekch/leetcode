#include <iostream>
using namespace std;
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class Solution {
    bool isValid(TreeNode *root, TreeNode *lower, TreeNode *upper) {
        if (root == NULL)
            return true;
        if ((lower && root->val <= lower->val) ||
            (upper && root->val >= upper->val)) {
            return false;
        }
        // pass left child the parent as uppper to smaller than
        // pass right child the parent as lower to bigger than
        return (isValid(root->left, lower, root) &&
                isValid(root->right, root, upper));
    }

  public:
    bool isValidBST(TreeNode *root) { return isValid(root, NULL, NULL); }
};
//     2
//    / \
//   1   3
// [2,1,3] true
// [5,1,4,null,null,3,6] false
//       10
//       / \
//      5  15
//         / \
//        11  20
//       / \  
//      6  16
// [10,5,15,null,null,11,20,6,16] false
// [2147483647] true