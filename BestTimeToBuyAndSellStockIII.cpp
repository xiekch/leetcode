#include<vector>
#include<queue>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
       int n=prices.size();
       int **dp=new int*[3]();
       for(int i=0;i<3;i++){
           dp[i]=new int[n+1]();
       }

       for(int i=1;i<=2;i++){
           for(int j=1;j<=n;j++){
               for(int k=1;k<j;k++){
                   dp[i][j]=max(dp[i][j-1],dp[i-1][j-1]+prices[i-1]-prices[k-1]);
               }
           }
       }
        
        return dp[2][n];
    }
};