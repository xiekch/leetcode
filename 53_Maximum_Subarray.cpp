#include <iostream>
#include <vector>
using namespace std;
// Given an integer array nums, find the contiguous subarray
// (containing at least one number) which has the largest sum and return its
// sum.
class Solution {
  public:
    int maxSubArray(vector<int> &nums) {
        if (nums.size() == 0)
            return 0;
        int curSum = 0, maxSum = nums[0];
        for (int i = 0; i < nums.size(); i++) {
            curSum += nums[i];
            maxSum = max(maxSum, curSum);
            // abandon the sum of preceding nums if less than 0
            curSum = max(0, curSum);
        }

        return maxSum;
    }
};

int main(int argc, char const *argv[]) {
    vector<int> test = {-2, -1};//, -3, 4, -1, 2, 1, -5, 4};
    Solution sol;
    cout << sol.maxSubArray(test) << endl;
    return 0;
}
