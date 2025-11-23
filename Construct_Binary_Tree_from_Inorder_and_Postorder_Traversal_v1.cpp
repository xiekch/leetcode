#include <iostream>
#include <vector>

#include "tree_utils.h"
using namespace std;
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
// struct TreeNode {
//     int val;
//     TreeNode* left;
//     TreeNode* right;
//     TreeNode() : val(0), left(nullptr), right(nullptr) {}
//     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//     TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
// };

class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if (preorder.empty()) {
            return nullptr;
        }
        TreeNode* root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.size(); i++) {
            if (inorder[i] == preorder[0]) {
                vector<int> subPreLeft = vector<int>(preorder.begin() + 1, preorder.begin() + 1 + i);
                vector<int> subInLeft = vector<int>(inorder.begin(), inorder.begin() + i);
                root->left = buildTree(subPreLeft, subInLeft);
                vector<int> subPreRight = vector<int>(preorder.begin() + i + 1, preorder.end());
                vector<int> subInRight = vector<int>(inorder.begin() + i + 1, inorder.end());
                root->right = buildTree(subPreRight, subInRight);

                break;
            }
        }
        return root;
    }
};

int main() {
    struct TestCase {
        vector<int> preorder;
        vector<int> inorder;
    };
    vector<TestCase> testCases = {{{3, 9, 20, 15, 7}, {9, 3, 15, 20, 7}}};
    Solution sol;
    for (auto testCase : testCases) {
        TreeUtil::printTree(sol.buildTree(testCase.preorder, testCase.inorder));
    }
    return 0;
}
