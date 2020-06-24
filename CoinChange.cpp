#include <iostream>
#include <vector>
using namespace std;

int coinChange(vector<int> &coins, int amount, int *minCoins) {
    if (amount < 0)
        return -1;
    if (amount == 0)
        return 0;
    if (minCoins[amount] != 0)
        return minCoins[amount];

    int minimal = 0xffffff, t;
    for (int coin : coins) {
        t = coinChange(coins, amount - coin, minCoins);
        if (minimal > t && t >= 0)
            minimal = t + 1;
    }
    minCoins[amount] = minimal < 0xffffff ? minimal : -1;
    return minCoins[amount];
}

int coinChange(vector<int> &coins, int amount) {
    return coinChange(coins, amount, new int[amount + 1]());
}

int main() {
    vector<int> coins = {1, 2, 5};
    int amount;
    cin >> amount;
    if (amount >= 0)
        cout << coinChange(coins, amount) << endl;

    return 0;
}
