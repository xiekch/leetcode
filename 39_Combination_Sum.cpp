#include <iostream>
#include <vector>
using namespace std;

// CSP
class Solution {
    vector<vector<int>> ans;
    int target;
    vector<int> candidates;

    int sum(vector<int> nums) {
        int res = 0;
        for (int i : nums) {
            res += i;
        }
        return res;
    }
    void backtrack(vector<int> vec, int index) {
        if (sum(vec) == target) {
            ans.push_back(vec);
            return;
        }
        if (sum(vec) > target)
            return;
        for (int i = index; i < candidates.size(); i++) {
            vec.push_back(candidates[i]);
            backtrack(vec, i);
            vec.pop_back();
        }
    }

  public:
    vector<vector<int>> combinationSum(vector<int> &candidates, int target) {
        this->target = target;
        this->candidates = candidates;
        vector<int> vec;
        backtrack(vec, 0);
        return this->ans;
    }
};
// Input: candidates = [2,3,5], target = 8,
// A solution set is:
// [
//   [2,2,2,2],
//   [2,3,3],
//   [3,5]
// ]
int main(int argc, char const *argv[]) {
    int arr1[] = {2, 3, 5};
    int arr2[] = {2, 3, 6, 7};
    // vector<int> candidates(arr1, arr1 + 3);
    vector<int> candidates(arr2, arr2 + 4);
    Solution sol;
    auto ans = sol.combinationSum(candidates, 7);

    for (auto i : ans) {
        for (auto j : i) {
            cout << j << " ";
        }
        cout << endl;
    }
    return 0;
}
