#include <vector>
using namespace std;
// Given n, how many structurally unique BST's (binary search trees)
//  that store values 1 ... n?
// https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
// Input: 3
// Output: 5
// the number of unique BST for a sequence of length n is the sum of
//  cartesian products of the number of BST for its left and right subtrees.
class Solution {
  public:
    int numTrees(int n) {
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
};