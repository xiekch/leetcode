#include <iostream>
#include <vector>
using namespace std;
// If the you burst balloon i you will get nums[left] * nums[i] * nums[right]
//  coins. Find the maximum coins you can collect by bursting the balloons
//  wisely.
// dp
// bottom up
class Solution {
  public:
    int maxCoins(vector<int> &nums) {
        if (nums.size() < 1)
            return 0;
        nums.insert(nums.begin(), 1);
        nums.push_back(1);

        vector<vector<int>> dp(nums.size(), vector<int>(nums.size()));
        for (int step = 2; step < nums.size(); step++) {
            for (int i = 0; i + step < nums.size(); i++) {
                int j = i + step;
                for (int k = i + 1; k < j; k++)
                    dp[i][j] = max(dp[i][j], nums[j] * nums[i] * nums[k] +
                                                 dp[i][k] + dp[k][j]);
            }
        }
        return dp[0][nums.size() - 1];
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
