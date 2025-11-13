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
            int left = i + 1;
            int right = nums.size() - 1;
            while (left < right) {
                int threeSum = nums[left] + nums[right] + nums[i];
                // cout << nums[i] << " " <<nums[left]<< " " << nums[right] <<threeSum << endl;
                if (threeSum == 0) {
                    result.emplace_back(std::vector<int>{nums[i], nums[left], nums[right]});
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (threeSum < 0) {
                    left++;
                } else {
                    right--;
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