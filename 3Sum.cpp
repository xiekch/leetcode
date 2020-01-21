#include <algorithm>
#include <vector>
using namespace std;

class Solution {
  public:
    vector<vector<int>> threeSum(vector<int> &nums) {
        vector<vector<int>> result;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.size(); j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = -(nums[i] + nums[j]);
                if (binary_search(nums.begin() + j + 1, nums.end(), k)) {
                    vector<int> v;
                    v.push_back(nums[i]);
                    v.push_back(nums[j]);
                    v.push_back(k);
                    result.push_back(v);
                }
            }
        }
        return result;
    }

    // ascending
    bool binarySearch(vector<int> &nums, int val, int low, int high) {
        if (low > high)
            return false;
        int middle = (low + high) / 2;
        if (nums[middle] == val)
            return true;
        if (nums[middle] > val)
            return binarySearch(nums, val, low, middle - 1);
        if (nums[middle] < val)
            return binarySearch(nums, val, middle + 1, high);
    }
};