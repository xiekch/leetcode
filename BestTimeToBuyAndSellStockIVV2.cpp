#include <vector>
using namespace std;

class Solution {
  public:
    int maxProfit(int k, vector<int> &prices) {
        if (prices.empty())
            return 0;
        if (k >= prices.size() / 2)
            return allProfit(prices);
        int n = prices.size(), minPrice, last;
        int *dp = new int[n]();

        for (int j = 1; j <= k; j++) {
            minPrice = prices[0], last = 0;
            for (int i = 1; i < n; i++) {
                minPrice = min(minPrice, prices[i] - last);
                last = dp[i];
                dp[i] = max(dp[i - 1], prices[i] - minPrice);
            }
        }

        return dp[n - 1];
    }

    int allProfit(vector<int> &prices) {
        int n = prices.size(), peak, valley, profit = 0;
        for (int i = 0; i < n - 1;) {
            while (prices[i] >= prices[i + 1] && i < n - 1)
                i++;
            valley = prices[i];
            while (prices[i] <= prices[i + 1] && i < n - 1)
                i++;
            peak = prices[i];
            profit += peak - valley;
        }
        return profit;
    }
};