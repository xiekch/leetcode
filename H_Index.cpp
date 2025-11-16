#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int hIndex(vector<int>& citations) {
        sort(citations.begin(), citations.end(), greater<int>());
        int index = 0;
        for (int i = 0; i < citations.size(); i++) {
            if (citations[i] >= i + 1) {
                index = i + 1;
            }
        }
        return index;
    }
};

int main() {
    vector<vector<int>> testCases = {{3, 0, 6, 1, 5}, {1, 3, 1}};
    Solution sol;
    for (auto testCase : testCases) {
        cout << sol.hIndex(testCase) << endl;
    }
    return 0;
}