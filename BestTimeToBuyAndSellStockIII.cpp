#include <vector>
using namespace std;

class Solution
{
  public:
    int maxProfit(vector<int> &prices)
    {
        int n = prices.size();
        int *minPrice = new int[n]();
        int *maxPrice = new int[n]();
        int profit1 = 0, profit2 = 0,profit=0;

        for (int i = 0; i < n; i++)
        {
            if (i == 0)
                minPrice[i] = prices[i];
            else
                minPrice[i] = prices[i] < minPrice[i - 1] ? prices[i] : minPrice[i - 1];
        }
        for (int i = n-1; i >=0;i--)
        {
            if (i == n-1)
                maxPrice[i] = prices[i];
            else
                maxPrice[i] = prices[i] > maxPrice[i + 1] ? prices[i] : maxPrice[i + 1];
        }

        for (int i = 0; i < n; i++)
        {
            profit1 = 0, profit2 = 0;
            for (int j = 0; j < i; j++)
            {
                profit1 = prices[j] - minPrice[j] > profit1 ? prices[j] - minPrice[j] : profit1;
            }
            for (int j = i;j<n;j++)
            {
                profit2 = maxPrice[j] -prices[j]> profit2 ? maxPrice[j] -prices[j] : profit2;
            }
            profit=profit>profit1+profit2?profit:profit1+profit2;
        }

        return profit;
    }
};