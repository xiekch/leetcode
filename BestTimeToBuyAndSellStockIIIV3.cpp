#include <vector>
using namespace std;

class Solution {
  public:
    int maxProfit(vector<int> &prices) {
        if (prices.empty())
            return 0;

        int n = prices.size(), minPrice;
        int **dp = new int *[3];
        for (int k = 0; k <= 2; k++) {
            dp[k] = new int[n]();
        }
        for (int k = 1; k <= 2; k++) {
            minPrice = prices[0];
            for (int i = 1; i < n; i++) {
                minPrice = min(minPrice, prices[i] - dp[k - 1][i - 1]);
                dp[k][i] = max(dp[k][i - 1], prices[i] - minPrice);
            }
        }

        return dp[2][n - 1];
    }
};