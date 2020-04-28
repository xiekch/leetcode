#pragma once
#include <cstdio>
#include <queue>
#include <string>
#include <vector>
using std::queue;
using std::string;
using std::vector;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : left(NULL), right(NULL) {}
    TreeNode(int v) : val(v), left(NULL), right(NULL) {}
    TreeNode(int v, TreeNode *right, TreeNode *left) : val(v), left(left), right(right) {}
};

class TreeUtil {
  private:
    static bool toInt(const string &str, int &num) {
        if (str.size() == 0 || str == "null" || str == "NULL") {
            return false;
        }
        num = std::stoi(str);
        return true;
    }

  public:
    TreeUtil() {}
    static TreeNode *build(vector<string> nums) {
        int num = 0;
        if (nums.size() == 0 || !toInt(nums[0], num))
            return NULL;
        toInt(nums[0], num);
        TreeNode *root = new TreeNode(num);
        queue<TreeNode *> qu;
        qu.push(root);
        for (int i = 1; i < nums.size() && !qu.empty();) {
            TreeNode *node = qu.front();
            qu.pop();
            if (toInt(nums[i], num)) {
                node->left = new TreeNode(num);
                qu.push(node->left);
            }
            i++;
            if (i < nums.size() && toInt(nums[i], num)) {
                node->right = new TreeNode(num);
                qu.push(node->right);
            }
            i++;
        }

        return root;
    }
    ~TreeUtil() {}

    static void printTree(TreeNode *root) {
        if (root == NULL)
            return;
        queue<TreeNode *> qu;
        qu.push(root);
        bool finished = false;
        while (!qu.empty() && !finished) {
            finished = true;
            int levelNum = qu.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode *node = qu.front();
                qu.pop();
                if (node != NULL) {
                    finished = false;
                    printf("%d ", node->val);
                    qu.push(node->left);
                    qu.push(node->right);
                } else {
                    printf("*");
                    qu.push(NULL);
                    qu.push(NULL);
                }
            }
            printf("\n");
        }
    }

    static void test() {
        vector<vector<string>> testset = {
            {"1", "2", "3", "null", "null", "null", "null"},
            {"1", "null", "2", "3"},
            {"1", "null", "2", "3", "4", "5"},
            {"5", "1", "4", "null", "null", "3", "6"},
            {"10", "5", "15", "null", "null", "11", "20", "6", "16"}};
        for (auto nums : testset) {
            TreeNode *root = TreeUtil::build(nums);
            TreeUtil::printTree(root);
        }
    }
};
