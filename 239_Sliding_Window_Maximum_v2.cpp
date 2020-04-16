#include <iostream>
#include <queue>
#include <vector>
using namespace std;
// You can only see the k numbers in the window. Each time the sliding window
// moves right by one position. Return the max sliding window.
// monotonic queue
class Solution {
  public:
    vector<int> maxSlidingWindow(vector<int> &nums, int k) {
        if (nums.size() <= 1) {
            return nums;
        }
        vector<int> ans;
        // store the indices of montomic entries
        deque<int> qu;
        for (int i = 0; i < nums.size(); i++) {
            if (!qu.empty() && qu.front() == i - k)
                qu.pop_front();
            while (!qu.empty() && nums[qu.back()] < nums[i]) {
                qu.pop_back();
            }
            qu.push_back(i);
            if (i >= k - 1)
                ans.push_back(nums[qu.front()]);
        }
        return ans;
    }
};

// Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
// Output: [3,3,5,5,6,7]

int main(int argc, char const *argv[]) {
    Solution sol;
    vector<int> test = {1, 3, -1, -3, 5, 3, 6, 7};
    auto i = sol.maxSlidingWindow(test, 3);
    for (auto j : i) {
        cout << j << " ";
    }
    cout << endl;
    return 0;
}
