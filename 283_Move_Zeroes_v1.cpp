#include <iostream>
#include <vector>
using namespace std;
class Solution {
  public:
    void moveZeroes(vector<int> &nums) {
        for (int nonzero = 0, zero = 0;
             nonzero < nums.size() && zero < nums.size();) {
            while (nonzero < nums.size() && nums[nonzero] != 0) {
                nonzero++;
            }
            zero = nonzero;
            while (zero < nums.size() && nums[zero] == 0) {
                zero++;
            }
            if (nonzero < nums.size() && zero < nums.size()) {
                swap(nums[nonzero], nums[zero]);
                nonzero++;
                zero++;
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
