#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> result;
        for (int i = 0; i < nums.size(); i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.size(); j++) {
                int twoSum = -(nums[i] + nums[j]);
                if (binary_search(nums.begin() + j + 1, nums.end(), twoSum)) {
                    // cout << nums[i] << nums[j] << twoSum << endl;
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    result.push_back({nums[i], nums[j], twoSum});
                }
            }
        }
        return result;
    }
};

int main() {
    Solution sol;
    vector<vector<int>> testCases = {{-1, 0, 1, 2, -1, -4}, {0, 1, 1}, {0, 0, 0, 0}};
    for (auto testCase : testCases) {
        auto answer = sol.threeSum(testCase);
        for (auto arr : answer) {
            for (auto j : arr) {
                cout << j << " ";
            }
            cout << endl;
        }
        cout << endl;
    }
    return 0;
}