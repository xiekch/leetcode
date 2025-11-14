#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int maxNum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i == maxNum && nums[i] == 0) {
                break;
            }
            if (i + nums[i] > maxNum) {
                maxNum = i + nums[i];
            }
        }
        return maxNum >= nums.size() - 1;
    }
};

int main() {
    Solution sol;
    vector<vector<int>> testCases = {{2, 3, 1, 1, 4}, {3, 2, 1, 0, 4}, {2, 1, 2, 2, 1, 2, 2, 2}};
    for (auto testCase : testCases) {
        cout << sol.canJump(testCase) << endl;
    }
    return 0;
}