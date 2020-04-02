#include <iostream>
#include <set>
#include <vector>
using namespace std;
// Given a non-empty array of integers, every element appears twice except for
// one.
//  Find that single one.
// Your algorithm should have a linear runtime complexity.
//  Could you implement it without using extra memory?
// https://leetcode.com/problems/single-number/solution/#approach-3-math
class Solution {
  public:
    int singleNumber(vector<int> &nums) {
        set<int> s;
        int sumOfSet = 0, sumOfNums = 0;
        for (int i : nums) {
            if (s.count(i) == 0) {
                s.insert(i);
                sumOfSet += i;
            }
            sumOfNums += i;
        }
        return 2 * sumOfSet - sumOfNums;
    }
};

Solution sol;
int main(int argc, char const *argv[]) {
    vector<int> test = {4, 2, 4}; // {4, 1, 2, 1, 2, 4, 5};
    cout << sol.singleNumber(test) << endl;
    return 0;
}
