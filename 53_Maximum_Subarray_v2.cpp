#include <iostream>
#include <vector>
using namespace std;
// Given an integer array nums, find the contiguous subarray
// (containing at least one number) which has the largest sum and return its
// sum.
// dp[i] means the maximum subarray ending with A[i];
class Solution {
  public:
    int maxSubArray(vector<int> &nums) {
        if (nums.size() == 0)
            return 0;
        vector<int> dp(nums.size(), 0);
        int maxSum = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            maxSum = max(maxSum, dp[i]);
        }

        return maxSum;
    }
};

int main(int argc, char const *argv[]) {
    vector<int> test = {-2, -1, -3, 4, -1, 2, 1, -5, 4};
    Solution sol;
    cout << sol.maxSubArray(test) << endl;
    return 0;
}
