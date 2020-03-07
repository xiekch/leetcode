#include <iostream>
#include <vector>
using namespace std;

// amortize
class Solution {
  public:
    int trap(vector<int> &height) {
        int ans = 0;
        for (int i = 0; i < height.size(); i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = max(max_left, height[j]);
            }
            for (int j = i; j < height.size(); j++) {
                max_right = max(max_right, height[j]);
            }

            ans += min(max_right, max_left) - height[i];
        }
        return ans;
    }
};