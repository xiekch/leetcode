#include <iostream>
#include <vector>
using namespace std;
// If the you burst balloon i you will get nums[left] * nums[i] * nums[right]
//  coins. Find the maximum coins you can collect by bursting the balloons
//  wisely.
// dp
// top down
class Solution {
    int burst(vector<int> &nums, int left, int right, vector<vector<int>> &dp) {
        if (left + 1 >= right)
            return 0;
        if (dp[left][right] > 0)
            return dp[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            ans = max(ans, nums[i] * nums[left] * nums[right] +
                               burst(nums, left, i, dp) +
                               burst(nums, i, right, dp));
        }
        dp[left][right] = ans;
        return ans;
    }

  public:
    int maxCoins(vector<int> &nums) {
        if (nums.size() < 1)
            return 0;
        nums.insert(nums.begin(), 1);
        nums.push_back(1);

        vector<vector<int>> dp(nums.size(), vector<int>(nums.size()));
        return burst(nums, 0, nums.size() - 1, dp);
    }
};

// Input: [3,1,5,8]
// Output: 167
// nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
// coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

int main(int argc, char const *argv[]) {
    Solution sol;
    vector<int> test = {3, 1, 5, 8};
    cout << sol.maxCoins(test) << endl;
    return 0;
}
