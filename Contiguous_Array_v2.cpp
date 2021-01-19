#include <iostream>
#include <map>
#include <vector>
using namespace std;
//  if we encounter the same diff twice while traversing the array,
//  it means that the number of zeros and ones are equal between the indices
//  corresponding to the equal diff values.
class Solution {
  public:
    int findMaxLength(vector<int> &nums) {
        if (nums.size() <= 1)
            return 0;
        int length = 0, diff = 0;
        //  to store the entries in the form of (index,diff)
        map<int, int> m;
        m[0] = -1;
        for (int i = 0; i < nums.size(); i++) {
            diff += (nums[i] == 0) ? -1 : 1;
            if (m.count(diff) == 0) {
                m[diff] = i;
            } else {
                length = max(length, i - m[diff]);
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
