#include <vector>
using namespace std;
// time limit exceeded
class Solution
{
  public:
    int maxProfit(int k, vector<int>& prices) {
        if (prices.empty())
            return 0;   

        int n = prices.size(), minPrice,last;
        int *dp = new int [n]();
        
        for (int j = 1; j <= k; j++)
        {
            minPrice = prices[0],last=0;
            for (int i = 1; i < n; i++)
            {
                minPrice = min(minPrice, prices[i] - last);
                last=dp[i];
                dp[i] = max(dp[i-1], prices[i] - minPrice);
            }
        }

        return dp[n-1];
    }

};