#include <iostream>
#include <stack>
#include <vector>
using namespace std;
// Given a 2d grid map of '1's (land) and '0's (water), count the number of
// islands.
// dfs
class Solution {
    int dd[4][2] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public:
    int numIslands(vector<vector<char>> &grid) {
        if (grid.size() == 0)
            return 0;
        int ans = 0, count = 1;
        vector<vector<bool>> visited(grid.size(),
                                     vector<bool>(grid[0].size(), false));
        stack<pair<int, int>> st;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    st.push(make_pair(i, j));
                    visited[i][j] = true;
                    while (!st.empty()) {
                        pair<int, int> point = st.top();
                        st.pop();
                        for (int k = 0; k < 4; k++) {
                            int newx = point.first + dd[k][0],
                                newy = point.second + dd[k][1];
                            if (newx >= 0 && newx < grid.size() && newy >= 0 &&
                                newy < grid[0].size() &&
                                grid[newx][newy] == '1' &&
                                !visited[newx][newy]) {
                                visited[newx][newy] = true;
                                st.push(make_pair(newx, newy));
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
};

// Input:
// 11110
// 11010
// 11000
// 00000
// Output: 1
// Input:
// 11110
// 11000
// 11010
// 01110
// Output: 1
// Input:
// 11110
// 11000
// 11010
// 00100
// Output: 3
int main(int argc, char const *argv[]) {
    vector<vector<char>> test = {{'1', '1', '1', '1', '0'},
                                 {'1', '1', '0', '1', '0'},
                                 {'1', '1', '0', '0', '0'},
                                 {'0', '0', '0', '0', '0'}};
    // vector<vector<char>> test = {{'1', '1', '1', '1', '0'},
    //                              {'1', '1', '0', '0', '0'},
    //                              {'1', '1', '0', '1', '0'},
    //                              {'0', '0', '1', '1', '0'}};
    // vector<vector<char>> test = {{'1', '1', '1', '1', '0'},
    //                              {'1', '1', '0', '0', '0'},
    //                              {'1', '1', '0', '1', '0'},
    //                              {'0', '0', '1', '0', '0'}};
    Solution sol;
    cout << sol.numIslands(test) << endl;
    return 0;
}
