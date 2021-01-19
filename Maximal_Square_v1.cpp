#include <iostream>
#include <vector>
using namespace std;
// Given a 2D binary matrix filled with 0's and 1's, find the largest square
// containing only 1's and return its area.
// BF
class Solution {
    int squareSize(int i, int j, const vector<vector<char>> &matrix) {
        int k = 0;
        while (i + k < matrix.size() && j + k < matrix[i].size()) {
            for (int m = j; m <= j + k; m++) {
                if (matrix[i + k][m] == '0')
                    return k;
            }
            for (int n = i; n <= i + k; n++) {
                if (matrix[n][j + k] == '0')
                    return k;
            }
            k++;
        }
        return k;
    }

  public:
    int maximalSquare(vector<vector<char>> &matrix) {
        if (matrix.size() == 0)
            return 0;
        int maximal = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[i].size(); j++) {
                if (matrix[i][j] == '1') {
                    int size = squareSize(i, j, matrix);
                    maximal = max(maximal, size * size);
                }
            }
        }
        return maximal;
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
    // vector<vector<char>> matrix = {{'1', '0', '1', '0', '0'},
    //                                {'1', '0', '1', '1', '1'},
    //                                {'1', '1', '1', '1', '1'},
    //                                {'1', '0', '0', '1', '0'}};

    vector<vector<char>> matrix = {{'1', '0', '1', '0', '0'},
                                   {'1', '0', '1', '1', '1'},
                                   {'1', '1', '1', '1', '1'},
                                   {'1', '1', '1', '1', '1'}};
    cout << sol.maximalSquare(matrix) << endl;
    return 0;
}
