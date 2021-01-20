#include <iostream>
#include <vector>
using namespace std;

// https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution
class Solution {
public:
    int maximalRectangle(vector<vector<char>> &matrix) {
        if (0 == matrix.size()) {
            return 0;
        }
        int height = matrix.size(), width = matrix[0].size();
        vector<int> le(width, 0), ri(width, width), high(width, 0);
        int maximum = -0xfffff;
        for (int i = 0; i < height; i++) {
            int cur_le = 0, cur_ri = width;
            for (int j = 0; j < width; j++) {
                if ('1' == matrix[i][j]) {
                    high[j] = high[j] + 1;
                } else {
                    high[j] = 0;
                }
            }
            for (int j = 0; j < width; j++) {
                if ('1' == matrix[i][j]) {
                    le[j] = max(le[j], cur_le);
                } else {
                    le[j] = 0;
                    cur_le = j + 1;
                }
            }
            for (int j = width - 1; j >= 0; j--) {
                if ('1' == matrix[i][j]) {
                    ri[j] = min(ri[j], cur_ri);
                } else {
                    ri[j] = width;
                    cur_ri = j;
                }
                maximum = max(maximum, (ri[j] - le[j]) * high[j]);
            }
        }
        return maximum;
    }
};

int main() {
    Solution solution;
    vector<vector<char>> testcase = {{'0', '1', '0'}, {'1', '1', '1'}};
    cout << solution.maximalRectangle(testcase) << endl;
    return 0;
}