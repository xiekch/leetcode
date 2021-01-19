#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;
// Given a non-empty array of integers, every element appears twice except for
// one.
//  Find that single one.
class Solution {
  public:
    int singleNumber(vector<int> &nums) {
        sort(nums.begin(), nums.end());
        int i;
        for (i = 0; i < nums.size() - 1;) {
            if (nums[i] == nums[i + 1]) {
                i += 2;
            } else
                break;
        }
        return nums[i];
    }
};

int main(int argc, char const *argv[]) {
    vector<int> test = {4, 1, 2, 1, 2};
    Solution sol;
    cout << sol.singleNumber(test) << endl;
    return 0;
}
