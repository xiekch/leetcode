#include <iostream>
#include <vector>
using namespace std;
// dp
class Solution {
    int rob(vector<int> nums, int start, int end, vector<vector<int>> &dp) {
        // printf("%d %d\n", start, end);
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        if (end - start == 1) {
            return nums[start];
        }
        if (end - start == 2) {
            return max(nums[start], nums[start + 1]);
        }
        return dp[start][end] = max(nums[start] + rob(nums, start + 2, end, dp),
                                    rob(nums, start + 1, end, dp));
    }

  public:
    int rob(vector<int> &nums) {
        if (nums.size() == 0)
            return 0;
        vector<vector<int>> dp(nums.size() + 1,
                               vector<int>(nums.size() + 1, -1));
        int dp1 = nums[0] + rob(nums, 2, nums.size() - 1, dp);
        int dp2 = rob(nums, 1, nums.size(), dp);
        // printf("%d %d \n", dp1, dp2);
        return max(dp1, dp2);
    }
};

int main(int argc, char const *argv[]) {

    Solution sol;
    vector<vector<int>> testset = {
        {2, 3, 2}, {1, 2, 3, 1}, {2, 4, 4, 5, 10, 7, 2, 3, 4, 5}};
    for (vector<int> nums : testset)
        cout << sol.rob(nums) << endl;
    return 0;
}
