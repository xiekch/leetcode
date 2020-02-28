#include <vector>
using namespace std;
// two pointers
class Solution {
  public:
    void sortColors(vector<int> &nums) {
        int two = nums.size() - 1, zero = 0;
        for (int i = 0; i <= two; i++) {
            while (nums[i] == 2 && i < two) {
                swap(nums[i], nums[two]);
                two--;
            }
            while (nums[i] == 0 && i > zero) {
                swap(nums[i], nums[zero]);
                zero++;
            }
        }
    }
};