#include <iostream>
#include <vector>
using namespace std;
// Given a 2d grid map of '1's (land) and '0's (water), count the number of
// islands.
// union find
class Solution {
    vector<int> groups = {0};
    bool unionGroup(int i, int j) {
        int x = findRoot(i), y = findRoot(j);
        if (x != y) {
            groups[x] = y;
            return true;
        }
        return false;
    }

    int findRoot(int i) {
        if (groups[i] == 0)
            return i;
        return groups[i] = findRoot(groups[i]);
    }

  public:
    int numIslands(vector<vector<char>> &grid) {
        if (grid.size() == 0)
            return 0;
        int count = 0;
        groups = {0};

        vector<vector<int>> mark(grid.size(), vector<int>(grid[0].size(), 0));
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && mark[i - 1][j] != 0 && j > 0 &&
                        mark[i][j - 1] != 0) {
                        if (unionGroup(mark[i][j - 1], mark[i - 1][j]))
                            count--;
                        mark[i][j] = mark[i - 1][j];
                    } else if (i > 0 && mark[i - 1][j] != 0) {
                        mark[i][j] = mark[i - 1][j];
                    } else if (j > 0 && mark[i][j - 1] != 0) {
                        mark[i][j] = mark[i][j - 1];
                    } else {
                        count++;
                        groups.push_back(0);
                        mark[i][j] = groups.size() - 1;
                    }
                }
            }
        }

        // for (int i = 0; i < mark.size(); i++) {
        //     for (int j = 0; j < mark[i].size(); j++) {
        //         cout << mark[i][j] << " ";
        //     }
        //     cout << endl;
        // }

        // for (int i = 0; i < groups.size(); i++) {
        //     cout << groups[i] << " ";
        // }
        // cout << endl;

        return count;
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
    vector<vector<vector<char>>> testset = {
        {{'1', '1', '1', '1', '0'},
         {'1', '1', '0', '0', '0'},
         {'1', '1', '0', '1', '0'},
         {'0', '1', '1', '1', '0'}},
        {{'1', '1', '1', '1', '0'},
         {'1', '1', '0', '0', '0'},
         {'1', '1', '0', '1', '0'},
         {'0', '0', '1', '1', '0'}},
        {{'1', '1', '1', '1', '0'},
         {'1', '1', '0', '0', '0'},
         {'1', '1', '0', '1', '0'},
         {'0', '0', '1', '0', '0'}},
        {{'1', '1', '1', '1', '1', '1', '1'},
         {'0', '0', '0', '0', '0', '0', '1'},
         {'1', '1', '1', '1', '1', '0', '1'},
         {'1', '0', '0', '0', '1', '0', '1'},
         {'1', '0', '1', '1', '1', '0', '1'},
         {'1', '0', '1', '0', '0', '0', '1'},
         {'1', '0', '1', '1', '1', '1', '1'}}};

    Solution sol;
    for (auto i : testset)
        cout << sol.numIslands(i) << endl;
    // cout << sol.numIslands(testset[3]) << endl;

    return 0;
}
