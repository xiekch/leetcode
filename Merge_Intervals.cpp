#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

void print(vector<vector<int>> &ans) {
    for (vector<int> i : ans) {
        cout << i[0] << " " << i[1] << endl;
    }
}

bool cmp(vector<int> &a, vector<int> &b) { return a[0] < b[0]; }

class Solution {
  public:
    vector<vector<int>> merge(vector<vector<int>> &intervals) {
        sort(intervals.begin(), intervals.end(), cmp);
        // int(intervals.size()) very important: size_t -> int
        // or i=1; i<intervals.size(); i++
        for (int i = 0; i < int(intervals.size()) - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i][1] = max(intervals[i + 1][1], intervals[i][1]);
                intervals.erase(intervals.begin() + i + 1);
                i--;
            }
        }
        return intervals;
    }
};

int main(int argc, char const *argv[]) {
    Solution s;
    vector<vector<int>> test = {{1, 2}, {2, 4}}, ans;
    ans = s.merge(test);
    print(ans);
    vector<vector<int>> test2;
    ans = s.merge(test2);
    print(ans);
    return 0;
}
