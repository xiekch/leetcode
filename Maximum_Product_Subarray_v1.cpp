#include <iostream>
#include <vector>
using namespace std;
// Given an integer array nums, find the contiguous subarray within an array
// (containing at least one number) which has the largest product.
// ERROR: Time Limit Exceeded
class Solution {
  public:
    int maxProduct(vector<int> &nums) {
        if (nums.size() == 0)
            return 0;
        int ans = nums[0];
        for (int i = 0; i < nums.size(); i++) {
            int product = 1;
            for (int j = i; j < nums.size(); j++) {
                product *= nums[j];
                ans = max(ans, product);
            }
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
