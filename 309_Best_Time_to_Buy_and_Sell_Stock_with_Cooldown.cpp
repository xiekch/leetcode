#include <iostream>
#include <vector>
using namespace std;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
class Solution {
  public:
    int maxProfit(vector<int> &prices) {
        if (prices.size() <= 1)
            return 0;
        vector<int> s0(prices.size());
        vector<int> s1(prices.size());
        vector<int> s2(prices.size());
        s1[0] = -prices[0];
        for (int i = 1; i < prices.size(); i++) {
            s0[i] = max(s0[i - 1], s2[i - 1]);
            s1[i] = max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
        }
        return max(s0[prices.size() - 1], s2[prices.size() - 1]);
    }
};

int main(int argc, char const *argv[]) {
    Solution sol;
    vector<vector<int>> testset = {{1, 2, 3, 0, 2}, {1, 2, 1, 100, 1, 2, 3}};
    for (auto prices : testset)
        cout << sol.maxProfit(prices) << endl;

    return 0;
}
