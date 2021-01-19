#include <iostream>
#include <vector>
using namespace std;

// a dp version to effectively calculate utmost right and left arrays
void printVector(vector<int> &vec) {
    for (int i : vec) {
        cout << i << " ";
    }
    cout << endl;
}
class Solution {
  public:
    int largestRectangleArea(vector<int> &heights) {
        int n = heights.size(), area = 0;
        if (n == 0)
            return 0;
        vector<int> lowR(n, 0);
        vector<int> lowL(n, 0);

        for (int i = 0; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && heights[i] <= heights[j]) {
                j = lowL[j];
            }
            lowL[i] = j;
        }

        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < n && heights[i] <= heights[j]) {
                j = lowR[j];
            }
            lowR[i] = j;
        }

        for (int i = 0; i < n; i++) {
            area = max(area, heights[i] * (lowR[i] - lowL[i] - 1));
            // cout<<area<<endl;
        }
        return area;
    }
};

// [2,1,5,6,2,3] 10
// [2,1,5,6,2,3,4,6,2,3] 16
int main(int argc, char const *argv[]) {
    Solution sol;
    vector<int> test = {2, 1, 5, 6, 2, 3, 4, 6, 2, 3};
    int ans = sol.largestRectangleArea(test);
    cout << ans << endl;
    return 0;
}
