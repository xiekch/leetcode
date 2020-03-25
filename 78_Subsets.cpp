#include <iostream>
#include <vector>
using namespace std;
// Given a set of distinct integers, nums,
//  return all possible subsets (the power set).

class Solution {
    vector<vector<int>> ans;
    vector<int> nums;
    void backtrack(vector<int> &cur, int index) {
        ans.push_back(cur);
        for (int i = index; i < nums.size(); i++) {
            cur.push_back(nums[i]);
            backtrack(cur, i + 1);
            cur.pop_back();
        }
    }

  public:
    vector<vector<int>> subsets(vector<int> &nums) {
        this->nums = nums;
        vector<int> vec;
        backtrack(vec, 0);
        return ans;
    }
};

int main(int argc, char const *argv[]) {
    vector<int> test = {1, 2, 3, 4};
    Solution sol;
    auto ans = sol.subsets(test);
    for (auto i : ans) {
        for (auto j : i) {
            cout << j << " ";
        }
        cout << endl;
    }
    return 0;
}
