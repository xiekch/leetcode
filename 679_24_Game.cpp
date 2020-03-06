#include <iostream>
#include <vector>
using namespace std;
// You need to judge whether they could operated
// through *, /, +, -, (, ) to get the< value of 24.
// brute force
// CSP backtracking
// 4 1 8 7 true (8-4)*(7-1)

void printVector(const vector<float> &a) {
    for (int i : a) {
        cout << i << " ";
    }
    cout << endl;
}

class Solution {
    vector<float> erase(vector<float> a, int i, int j) {
        a.erase(a.begin() + i);
        a.erase(a.begin() + j - 1);
        return a;
    }

  public:
    bool judgePoint24(vector<int> &nums) {
        vector<float> floatNums;
        for (int i : nums) {
            floatNums.push_back(i);
        }
        return judgePoint24(floatNums);
    }

    bool judgePoint24(vector<float> nums) {
        if (nums.size() == 0)
            return false;
        if (nums.size() == 1)
            return abs(nums[0] - 24) < 1e-4;

        vector<float> parent;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                parent = erase(nums, i, j);
                parent.push_back(nums[i] + nums[j]);
                // printVector(parent);
                if (judgePoint24(parent)) {
                    return true;
                }
                parent.pop_back();

                parent.push_back(nums[i] - nums[j]);
                if (judgePoint24(parent)) {
                    return true;
                }
                parent.pop_back();

                parent.push_back(nums[j] - nums[i]);
                if (judgePoint24(parent)) {
                    return true;
                }
                parent.pop_back();

                parent.push_back(nums[i] * nums[j]);
                if (judgePoint24(parent)) {
                    return true;
                }
                parent.pop_back();

                if (nums[j] != 0) {
                    parent.push_back(nums[i] / nums[j]);
                    if (judgePoint24(parent)) {
                        return true;
                    }
                    parent.pop_back();
                }

                if (nums[i] != 0) {
                    parent.push_back(nums[j] / nums[i]);
                    if (judgePoint24(parent)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
};

int main(int argc, char const *argv[]) {
    Solution sol;
    int testset[5][4] = {
        {6, 6, 6, 6}, {4, 1, 8, 7}, {2, 6, 2, 6}, {1, 2, 1, 2}, {1, 3, 4, 6}};
    for (int i = 0; i < 5; i++) {
        vector<float> nums(testset[i], testset[i] + 4);
        printVector(nums);
        bool ans = sol.judgePoint24(nums);
        cout << ans << endl;
    }
    return 0;
}
