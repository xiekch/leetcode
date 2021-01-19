#include <algorithm>
#include <iostream>
#include <set>
#include <vector>
using namespace std;
// Given an unsorted array of integers, find the length of
//  the longest consecutive elements sequence.
// Your algorithm should run in O(n) complexity.
// Input: [100, 4, 200, 1, 3, 2]
// Output: 4

class Solution {
  public:
    int longestConsecutive(vector<int> &nums) {
        if (nums.size() == 0)
            return 0;

        set<int> s;
        for (int i : nums) {
            s.insert(i);
        }
        int longest = 1;
        for (int i = 0; i < nums.size(); i++) {
            if (s.count(nums[i] - 1) == 0) {
                int t = nums[i] + 1, curlength = 1;
                while (s.count(t)) {
                    t++;
                    curlength++;
                }
                longest = max(longest, curlength);
            }
        }
        return longest;
    }
};

int main(int argc, char const *argv[]) {
    // vector<int> test = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    // vector<int> test = {100, 4, 200, 1, 3, 2};
    vector<int> test = {1, 2, 0, 1};
    Solution sol;
    cout << sol.longestConsecutive(test) << endl;
    return 0;
}
