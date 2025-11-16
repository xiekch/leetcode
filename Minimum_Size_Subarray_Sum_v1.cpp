// Given an array of positive integers nums and a positive integer target,
// return the minimal length of a subarray whose sum is greater than or equal to target.
// If there is no such subarray, return 0 instead.

#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int left = 0, right = 0;
        int sum = 0;
        int minLen = nums.size() + 1;
        while (right < nums.size()) {
            if (sum < target) {
                sum += nums[right];
                right++;
            }
            while (sum >= target && left < right) {
                minLen = min(right - left, minLen);
                sum -= nums[left];
                left++;
            }
            // cout << left << " " << right << " " << sum << endl;
        }
        if (minLen > nums.size()) {
            return 0;
        }
        return minLen;
    }
};

int main() {
    struct TestCase {
        vector<int> nums;
        int target;
    };

    vector<TestCase> testCases = {{{2, 3, 1, 2, 4, 3}, 7}, {{1, 1, 1, 1, 1, 1, 1, 1}, 11}};
    Solution sol;
    for (auto& testCase : testCases) {
        cout << sol.minSubArrayLen(testCase.target, testCase.nums) << endl;
    }
    return 0;
}