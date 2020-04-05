#include <iostream>
#include <vector>
using namespace std;
class Solution {
  public:
    void moveZeroes(vector<int> &nums) {
        int lastNonZero = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != 0) {
                nums[lastNonZero++] = nums[i];
            }
        }
        for (; lastNonZero < nums.size(); lastNonZero++) {
            nums[lastNonZero] = 0;
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
