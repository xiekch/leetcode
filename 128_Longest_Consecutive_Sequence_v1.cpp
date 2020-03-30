#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;
// Given an unsorted array of integers, find the length of
//  the longest consecutive elements sequence.
// Input: [100, 4, 200, 1, 3, 2]
// Output: 4

class Solution {
  public:
    int longestConsecutive(vector<int> &nums) {
        if (nums.size() == 0)
            return 0;
        sort(nums.begin(), nums.end());
        int longest = 1, curlength = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] == nums[i - 1] + 1) {
                curlength++;
                longest = max(longest, curlength);
            } else if (nums[i] == nums[i - 1]) {
            } else {
                curlength = 1;
            }
        }
        return longest;
    }
};

int main(int argc, char const *argv[]) {
    // vector<int> test = {100, 4, 200, 1, 3, 2};
    vector<int> test = {1, 2, 0, 1};
    Solution sol;
    cout << sol.longestConsecutive(test) << endl;
    return 0;
}
