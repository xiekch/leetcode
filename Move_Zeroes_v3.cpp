#include <iostream>
#include <vector>
using namespace std;
class Solution {
  public:
    void moveZeroes(vector<int> &nums) {
        for (int cur = 0, lastNonZero = 0; cur < nums.size(); cur++) {
            if (nums[cur] != 0) {
                swap(nums[lastNonZero++], nums[cur]);
            }
        }
    }
};

int main(int argc, char const *argv[]) {
    vector<vector<int>> testset = {
        {0, 0, 1, 0, 3, 12}, {1, 0, 3, 12, 0}, {1, 3, 12}, {0, 0, 0, 0}};
    Solution sol;
    for (auto test : testset) {
        sol.moveZeroes(test);
        for (auto nonzero : test) {
            cout << nonzero << " ";
        }
        cout << endl;
    }
    return 0;
}
