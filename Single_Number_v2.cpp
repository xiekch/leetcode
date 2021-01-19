#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;
// Given a non-empty array of integers, every element appears twice except for
// one.
//  Find that single one.
// Your algorithm should have a linear runtime complexity.
//  Could you implement it without using extra memory?
// https://leetcode.com/problems/single-number/solution/#approach-4-bit-manipulation
class Solution {
  public:
    int singleNumber(vector<int> &nums) {
        int ans = 0;
        for (int i : nums) {
            ans ^= i;
        }
        return ans;
    }
};

int main(int argc, char const *argv[]) {
    vector<int> test = {4, 1, 2, 1, 2, 4, 5};
    Solution sol;
    cout << sol.singleNumber(test) << endl;
    return 0;
}
