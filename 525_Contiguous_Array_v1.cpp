#include <iostream>
#include <vector>
using namespace std;
// ERROR: Time Limit Exceeded
class Solution {
  public:
    int findMaxLength(vector<int> &nums) {
        if (nums.size() <= 1)
            return 0;
        int length = 0;
        vector<int> zeros(nums.size() + 1, 0), ones(nums.size() + 1, 0);

        for (int i = 1; i <= nums.size(); i++) {
            if (nums[i - 1] == 0) {
                zeros[i] = zeros[i - 1] + 1;
                ones[i] = ones[i - 1];
            } else {
                ones[i] = ones[i - 1] + 1;
                zeros[i] = zeros[i - 1];
            }
        }
        for (int i = 0; i <= nums.size(); i++) {
            for (int j = i + 2; j <= nums.size(); j++) {
                if (zeros[j] - zeros[i] == ones[j] - ones[i]) {
                    length = max(length, j - i);
                }
            }
        }
        return length;
    }
};

// input:0,0,1,1 output:4

int main(int argc, char const *argv[]) {
    Solution sol;
    vector<vector<int>> testset = {
        {0, 0, 1, 1}, {0, 1, 0}, {0, 0, 1, 0, 1, 0, 0, 1, 1}};
    for (auto test : testset)
        cout << sol.findMaxLength(test) << endl;
    return 0;
}
