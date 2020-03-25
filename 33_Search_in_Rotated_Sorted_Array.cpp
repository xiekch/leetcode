#include <iostream>
#include <vector>
using namespace std;

// first find the 'pivot', then binary search
// O(logn)
class Solution {
    int findPivot(vector<int> &nums) {
        if (nums.size() <= 1)
            return 0;
        int n = nums.size();
        int mid, le, ri;
        le = 0, ri = n - 1;
        mid = (n) / 2;
        while (le < ri) {
            mid = (ri + le) / 2;
            if (nums[mid] > nums[ri]) {
                // cout << 11 << endl;
                le = mid + 1;
            } else {
                // cout << 22 << endl;
                ri = mid;
            }
        }
        // not mid
        return le;
    }

  public:
    int search(vector<int> &nums, int target) {
        if (nums.size() == 0)
            return -1;
        int n = nums.size();
        int pivot = findPivot(nums);
        // cout << pivot << endl;

        int le, ri;
        if (target == nums[pivot]) {
            return pivot;
        } else if (target <= nums[n - 1]) {
            le = pivot;
            ri = n - 1;
        } else {
            le = 0;
            ri = pivot - 1;
        }
        while (le <= ri) {
            int mid = le + (ri - le) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                le = mid + 1;
            else
                ri = mid - 1;
        }
        return -1;
    }
};

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// [3,1] 1
int main(int argc, char const *argv[]) {
    vector<int> test = {4, 5, 6, 7, 0, 1, 2};
    Solution sol;
    int ans = sol.search(test, 0);
    cout << ans << endl;

    return 0;
}
