#include <iostream>
#include <vector>
using namespace std;

class Solution {
    int findLeft(vector<int> &nums, int target) {
        if (nums.size() == 0)
            return -1;
        int low = 0, high = nums.size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low < nums.size() && nums[low] == target)
            return low;
        return -1;
    }

    int findRight(vector<int> &nums, int target) {
        if (nums.size() == 0)
            return -1;
        int low = 0, high = nums.size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (high >= 0 && nums[high] == target)
            return high;
        return -1;
    }

  public:
    vector<int> searchRange(vector<int> &nums, int target) {
        vector<int> res;
        res.push_back(findLeft(nums, target));
        res.push_back(findRight(nums, target));
        return res;
    }
};

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

int main(int argc, char const *argv[]) {
    vector<int> test = {5, 7, 7, 8, 8, 10};
    Solution sol;
    vector<int> res = sol.searchRange(test, 10);
    cout << res[0] << " " << res[1] << endl;
    return 0;
}
