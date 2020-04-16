#include <iostream>
#include <vector>
using namespace std;
// output[i] is equal to the product of all the elements of nums except nums[i].
// Note: Please solve it without division and in O(n).
class Solution {
  public:
    vector<int> productExceptSelf(vector<int> &nums) {
        vector<int> output(nums.size(), 1);
        for (int i = 1; i < nums.size(); i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        int prev = 1;
        for (int i = nums.size() - 2; i >= 0; i--) {
            prev *= nums[i + 1];
            output[i] *= prev;
        }

        return output;
    }
};

int main(int argc, char const *argv[]) {
    Solution sol;
    vector<int> test = {1, 2, 3, 4};
    // vector<int> test = {1, 2};
    auto i = sol.productExceptSelf(test);
    for (auto j : i)
        cout << j << " ";
    cout << endl;
    return 0;
}
