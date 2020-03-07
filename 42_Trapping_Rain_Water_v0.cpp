#include <iostream>
#include <vector>
using namespace std;

// my odd solution
class Solution {
  public:
    int trap(vector<int> &height) {
        int sum = 0;
        for (int start = 0, end = height.size() - 1; start < end;) {
            if (height[start] > 0 && height[end] > 0) {
                for (int i = start; i <= end; i++) {
                    height[i]--;
                }
            }
            if (height[start] <= 0)
                start++;
            if (height[end] <= 0)
                end--;
        }

        for (int i = 0; i < height.size(); i++) {
            if (height[i] < 0) {
                sum += -height[i];
            }
        }
        return sum;
    }
};