#include "tree_utils.h"
#include <iostream>
#include <stack>
#include <vector>
using namespace std;
// inorder traversal

// struct TreeNode {
//     int val;
//     TreeNode *left;
//     TreeNode *right;
//     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
// };
class Solution {
  public:
    bool isValidBST(TreeNode *root) {
        if (root == NULL)
            return true;
        vector<int> nums;
        stack<TreeNode *> st;
        // do not rely on buggy INT_MAX, INT_MIN solutions any more
        // double prev = -0xfffffff;
        TreeNode *prev = NULL;
        TreeNode *cur = root;
        while (!st.empty() || cur != NULL) {
            while (cur != NULL) {
                st.push(cur);
                cur = cur->left;
            }

            cur = st.top();
            st.pop();
            if (prev != NULL && cur->val <= prev->val) {
                return false;
            }
            prev = cur;
            cur = cur->right;
        }
        return true;
    }
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
// [-2147483648] true
int main(int argc, char const *argv[]) {
    Solution sol;
    vector<vector<string>> testset = {
        {"2", "1", "3", "null", "null", "null", "null"},
        {"5", "1", "4", "null", "null", "3", "6"},
        {"10", "5", "15", "null", "null", "11", "20", "6", "16"},
        {"2147483647"},
        {"-2147483648"}};
    for (auto nums : testset) {
        TreeNode *root = TreeUtil::buildTree(nums);
        cout << sol.isValidBST(root) << endl;
    }
    return 0;
}
