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
  public:
    vector<vector<int>> levelOrder(TreeNode *root) {
        vector<vector<int>> ans;
        if (root == NULL)
            return ans;
        queue<TreeNode *> qu;
        qu.push(root);
        while (!qu.empty()) {
            int levelNum = qu.size();
            vector<int> sub;
            for (int i = 0; i < levelNum; i++) {
                root = qu.front();
                qu.pop();
                sub.push_back(root->val);
                if (root->left != NULL) {
                    qu.push(root->left);
                }
                if (root->right != NULL) {
                    qu.push(root->right);
                }
            }
            ans.push_back(sub);
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
