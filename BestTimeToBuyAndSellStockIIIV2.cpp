#include<vector>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.empty())return 0;

        int n=prices.size(),minPrice;
        int **dp=new int *[3];
        for(int k=0;k<=2;k++){
            dp[k]=new int[n]();
        }
        for(int k=1;k<=2;k++){
        for(int i=1;i<n;i++){
            minPrice=prices[0];
            for(int j=1;j<=i;j++){
                if(prices[j]-dp[k-1][j-1]<minPrice){
                    minPrice=prices[j]-dp[k-1][j-1];
                }
            }
            dp[k][i]=max(dp[k][i-1],prices[i]-minPrice);
        }
        }
        return dp[2][n-1];
    }
};