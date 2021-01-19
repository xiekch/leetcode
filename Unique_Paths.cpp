#include <cstring>
class Solution {
  public:
    int arr[101][101];
    int uniquePaths(int m, int n) {
        memset(arr, 0, sizeof(arr));
        for (int i = 1; i <= m; i++) {
            arr[i][1] = 1;
            for (int j = 2; j <= n; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[m][n];
    }
};