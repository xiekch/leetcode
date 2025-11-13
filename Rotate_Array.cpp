#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        k = k % n;
        vector<int> temp;
        for (int i = n - k; i < n; i++) {
            temp.push_back(nums[i]);
        }
        for (int i = 0; i < n - k; i++) {
            temp.push_back(nums[i]);
        }

        nums = temp;
    }
};

int main() {
    Solution sol;
    struct Input {
        vector<int> arr;
        int k;
    };

    vector<Input> testCases = {{{1, 2, 3, 4, 5, 6, 7}, 3}, {{-1, -100, 3, 99}, 2}};
    for (auto& input : testCases) {
        sol.rotate(input.arr, input.k);
        for (int i : input.arr) {
            cout << i << " ";
        }
        cout << endl;
    }
    return 0;
}