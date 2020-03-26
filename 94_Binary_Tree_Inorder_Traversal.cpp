#include <stack>
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
  public:
    vector<int> inorderTraversal(TreeNode *root) {
        vector<int> ans;
        stack<TreeNode *> st;
        while (!st.empty() || root != NULL) {
            while (root != NULL) {
                st.push(root);
                root = root->left;
            }
            root = st.top();
            st.pop();
            ans.push_back(root->val);

            root = root->right;
        }
        return ans;
    }
};

// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3
// Output: [1,3,2]