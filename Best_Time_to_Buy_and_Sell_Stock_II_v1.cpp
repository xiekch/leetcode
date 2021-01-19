#include <iostream>
#include <vector>
using namespace std;
class Solution {
  public:
    int maxProfit(vector<int> &prices) {
        int ans = 0, buy = 0;
        for (int i = 0; i < prices.size(); i++) {
            // find the minimal to buy
            for (; i < prices.size() - 1 && prices[i] >= prices[i + 1]; i++)
                ;
            buy = prices[i];

            // find the maximal to sell
            for (; i < prices.size() - 1 && prices[i] <= prices[i + 1]; i++)
                ;
            ans += prices[i] - buy;
        }
        return ans;
    }
};

// Input: [7,1,5,3,6,4]
// Output: 7
// Input: [1,2,3,4,5]
// Output: 4
// Input: [7,6,4,3,1]
// Output: 0
int main(int argc, char const *argv[]) {
    vector<vector<int>> testset = {
        {7, 1, 5, 3, 6, 4}, {1, 2, 3, 4, 5}, {7, 6, 4, 3, 1}};
    Solution sol;
    for (auto test : testset) {
        cout << sol.maxProfit(test) << endl;
    }
    return 0;
}
