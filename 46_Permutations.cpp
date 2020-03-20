#include <iostream>
#include <vector>
using namespace std;
// Given a collection of distinct integers, return all possible permutations.
// CSP
class Solution {
    vector<vector<int>> ans;
    vector<int> nums;
    void backtrack(vector<int> &cur, vector<bool> &has) {
        if (cur.size() == nums.size()) {
            ans.push_back(cur);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (has[i] == false) {
                cur.push_back(nums[i]);
                has[i] = true;
                backtrack(cur, has);
                cur.pop_back();
                has[i] = false;
            }
        }
    }

  public:
    vector<vector<int>> permute(vector<int> &nums) {
        this->nums = nums;
        vector<int> cur;
        vector<bool> has(nums.size(), false);
        backtrack(cur, has);
        return this->ans;
    }
};

int main(int argc, char const *argv[]) {
    Solution sol;
    int arr[] = {1, 2, 3, 4};
    vector<int> nums(arr, arr + 4);
    auto ans = sol.permute(nums);
    for (auto i : ans) {
        for (auto j : i) {
            cout << j << " ";
        }
        cout << endl;
    }
    return 0;
}
