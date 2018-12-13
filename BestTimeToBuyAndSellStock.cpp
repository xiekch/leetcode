#include<vector>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.empty())return 0;
        int n=prices.size();
        int profit=0,minPrice=prices[0];//prices can be empty 
        for(int i=1;i<n;i++){
            profit=prices[i]-minPrice>profit?prices[i]-minPrice:profit;
            minPrice=prices[i]<minPrice?prices[i]:minPrice;
        }

        return profit;
    }
};