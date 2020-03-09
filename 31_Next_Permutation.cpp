#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

// one pass
class Solution {
  public:
    void nextPermutation(vector<int> &nums) {
        if (nums.size() <= 1)
            return;
        int i = 0, curMin = 0xfffff, curMinIndex = -1;
        for (i = nums.size() - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.size() - 1; j >= 0; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums[i], nums[j]);
                        break;
                    }
                }
                sort(nums.begin() + i + 1, nums.end());
                return;
            }
        }
        sort(nums.begin(), nums.end());
    }
};


// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1
// 1,3,2 → 2,1,3
// 2,3,1 → 3,1,2
int main(int argc, char const *argv[]) {
    Solution sol;
    int testset[][3] = {{1, 2, 3}, {3, 2, 1}, {1, 1, 5}, {1, 3, 2}, {2, 3, 1}};
    for (int i = 0; i < 5; i++) {
        vector<int> t(testset[i], testset[i] + 3);
        sol.nextPermutation(t);
        for (int j : t) {
            cout << j << " ";
        }
        cout << endl;
    }
    return 0;
}