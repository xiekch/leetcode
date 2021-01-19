#include <iostream>
#include <vector>
using namespace std;
// Given an integer array nums, find the contiguous subarray within an array
// (containing at least one number) which has the largest product.
// https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity
class Solution {
  public:
    int maxProduct(vector<int> &nums) {
        if (nums.size() == 0)
            return 0;
        int ans, imin, imax;
        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        ans = imin = imax = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] < 0)
                swap(imin, imax);

            // max/min product for the current number is either the current
            // number itself or the max/min by the previous number times the
            // current one
            imin = min(imin * nums[i], nums[i]);
            imax = max(imax * nums[i], nums[i]);
            ans = max(ans, imax);
        }
        return ans;
    }
};

// Input: [2,3,-2,4]
// Output: 6
int main(int argc, char const *argv[]) {
    vector<int> test = {2, 3, -2, 4};
    // vector<int> test = {0, 2};
    Solution sol;
    cout << sol.maxProduct(test) << endl;
    return 0;
}
