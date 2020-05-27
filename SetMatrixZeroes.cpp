#include <iostream>
#include <set>
#include <vector>
using namespace std;

class Solution {
  public:
    void setZeroes(vector<vector<int>> &matrix) {
        set<int> row, column;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[0].size(); j++) {
                if (matrix[i][j] == 0) {
                    row.insert(i);
                    column.insert(j);
                }
            }
        }

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[0].size(); j++) {
                if (row.count(i) || column.count(j))
                    matrix[i][j] = 0;
            }
        }
    }
};