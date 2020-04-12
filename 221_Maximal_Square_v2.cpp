#include <iostream>
#include <vector>
using namespace std;
// Given a 2D binary matrix filled with 0's and 1's, find the largest square
// containing only 1's and return its area.
// DP
class Solution {
  public:
    int maximalSquare(vector<vector<char>> &matrix) {
        if (matrix.size() == 0)
            return 0;
        int maximal = 0;
        // one more row and column to compact code
        vector<vector<int>> dp(matrix.size() + 1,
                               vector<int>(matrix[0].size() + 1, 0));
        for (int i = 1; i <= matrix.size(); i++) {
            for (int j = 1; j <= matrix[0].size(); j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] =
                        min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) +
                        1;
                    maximal = max(maximal, dp[i][j]);
                }
            }
        }

        return maximal * maximal;
    }
};

// Input:
// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
// Output: 4
int main(int argc, char const *argv[]) {
    Solution sol;
    vector<vector<char>> matrix = {{'1', '0', '1', '0', '0'},
                                   {'1', '0', '1', '1', '1'},
                                   {'1', '1', '1', '1', '1'},
                                   {'1', '0', '0', '1', '0'}};

    // vector<vector<char>> matrix = {{'1', '0', '1', '0', '0'},
    //                                {'1', '0', '1', '1', '1'},
    //                                {'1', '1', '1', '1', '1'},
    //                                {'1', '1', '1', '1', '1'}};
    cout << sol.maximalSquare(matrix) << endl;
    return 0;
}
