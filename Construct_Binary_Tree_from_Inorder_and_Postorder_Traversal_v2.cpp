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

class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return buildTree(preorder, inorder, 0, preorder.size(), 0, inorder.size());
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart >= pEnd) {
            return nullptr;
        }
        TreeNode* root = new TreeNode(preorder[pStart]);
        for (int i = 0; i + iStart < iEnd; i++) {
            if (inorder[i + iStart] == preorder[pStart]) {
                root->left = buildTree(preorder, inorder, pStart + 1, pStart + i + 1, iStart, iStart + i);
                root->right = buildTree(preorder, inorder, pStart + i + 1, pEnd, iStart + i + 1, iEnd);
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
