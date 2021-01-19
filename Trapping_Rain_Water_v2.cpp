#include <iostream>
#include <vector>
using namespace std;

// Using 2 pointers
class Solution {
  public:
    int trap(vector<int> &height) {
        int sum = 0;
        int left_max = 0, right_max = 0;
        for (int start = 0, end = height.size() - 1; start < end;) {
            if (height[start] < height[end]) {
                if (height[start] < left_max)
                    sum += left_max - height[start];
                else
                    left_max = height[start];
                start++;
            } else {
                if (height[end] < right_max)
                    sum += right_max - height[end];
                else
                    right_max = height[end];
                end--;
            }
        }

        return sum;
    }
};