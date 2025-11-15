#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int jump(vector<int>& nums) {
        if (nums.size() <= 1) {
            return 0;
        }
        vector<int> minSteps(nums.size(), INT_MAX);
        minSteps[0] = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (minSteps[i] == INT_MAX) {
                break;
            }
            for (int j = 1; j <= nums[i] && i + j < nums.size(); j++) {
                minSteps[i + j] = min(minSteps[i + j], minSteps[i] + 1);
            }
        }
        if (minSteps[nums.size() - 1] == INT_MAX) {
            return -1;
        }
        return minSteps[nums.size() - 1];
    }
};

int main() {
    Solution sol;
    vector<vector<int>> testCases = {{2, 3, 1, 1, 4}, {3, 2, 1, 0, 4}, {2, 1, 2, 2, 1, 2, 2, 2}};
    for (auto testCase : testCases) {
        cout << sol.jump(testCase) << endl;
    }
    return 0;
}