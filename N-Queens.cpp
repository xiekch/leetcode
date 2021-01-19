#include <cmath>
#include <string>
#include <vector>
using namespace std;

class Solution {
    int **vis;
    vector<string> result;
    vector<vector<string>> total;
    int n;

  public:
    vector<vector<string>> solveNQueens(int n) {
        result = vector<string>(n, string(n, '.'));
        vis = new int *[3]();
        for (int i = 0; i < 3; i++)
            vis[i] = new int[2 * n]();
        this->n = n;
        backtracking(0);
        return total;
    }

    void backtracking(int cur) {
        if (cur == n) {
            total.push_back(result);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!vis[0][i] && !vis[1][cur - i + n] && !vis[2][cur + i]) {
                // cout<<cur<<":"<<i<<"  ";
                result[cur][i] = 'Q';
                vis[0][i] = vis[1][cur - i + n] = vis[2][cur + i] = 1;
                backtracking(cur + 1);
                vis[0][i] = vis[1][cur - i + n] = vis[2][cur + i] = 0;
                result[cur][i] = '.';
            }
        }
    }
};