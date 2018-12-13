#include<iostream>
#include<vector>
using namespace std;

int coinChange(vector<int>& coins,int amount ,int *minCoins);
int coinChange(vector<int>& coins,int amount){
	return coinChange(coins,amount,new int[amount+1]());
}

int coinChange(vector<int>& coins,int amount ,int *minCoins){
	if(amount<0)return -1;
	if(amount==0)return 0;
	if(minCoins[amount]!=0)return minCoins[amount];

	int min=INT_MAX,t;
	for(int coin:coins){
		t=coinChange(coins,amount-coin,minCoins);
		if(min>t&&t>=0)min=t+1;
	}
	minCoins[amount]=min<INT_MAX?min:-1;
	return minCoins[amount];
}

int main()
{	
	vector<int> coins= {1,2,5};
	int amount;
	cin>>amount;
	if (amount >= 0)cout<<coinChange(coins,amount)<<endl;
	
	return 0;
}
