#include <iostream>
#include <vector>
using namespace std;
// Each time you can either climb 1 or 2 steps.
//  In how many distinct ways can you climb to the top?
class Solution {
  public:
    int climbStairs(int n) {
        if (n < 0)
            return 0;
        if (n == 0 || n == 1)
            return 1;
        vector<int> dp(n + 1);
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
};

int main(int argc, char const *argv[]) {
    Solution sol;
    cout << sol.climbStairs(3) << endl;
    return 0;
}
