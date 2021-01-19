#include <algorithm>
#include <string>
using namespace std;
// https://leetcode.com/problems/edit-distance/discuss/25846/C%2B%2B-O(n)-space-DP
// we define the state dp[i][j] to be the minimum number of operations
//  to convert word1[0..i) to word2[0..j)

// states (stored)
// state transition (exploit the stored)
class Solution {
  public:
    int minDistance(string word1, string word2) {
        int m = word1.length(), n = word2.length();

        if (m == 0 || n == 0)
            return m + n;

        int **dp = new int *[m + 1]();
        for (int i = 0; i <= m; i++)
            dp[i] = new int[n + 1]();

        for (int i = 0; i <= m; i++)
            dp[i][0] = i;

        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                    // dp[i][j] = min(dp[i][j - 1] + 1,
                    //                min(dp[i - 1][j] + 1, dp[i - 1][j - 1]));
                    // dp[i][j - 1] + 1 >= dp[i][j]
                    // otherwise, dp[i][j-1] and dp[i][j] differ more than 1
                } else {
                    dp[i][j] = min(dp[i][j - 1] + 1,
                                   min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }

        return dp[m][n];
    }
};