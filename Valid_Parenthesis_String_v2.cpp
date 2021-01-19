#include <iostream>
#include <stack>
#include <string>
#include <vector>
using namespace std;
// '*' could be treated as a single right parenthesis ')' or a single left
// parenthesis '(' or an empty string.
// https://leetcode.com/problems/valid-parenthesis-string/solution/#approach-3-greedy-accepted
class Solution {
  public:
    bool checkValidString(string s) {
        // the bounds of left brackets
        int lowerbound = 0, higherbound = 0;
        for (char ch : s) {
            if (ch == '(')
                lowerbound += 1;
            else
                lowerbound += -1;
            if (ch == ')')
                higherbound += -1;
            else
                higherbound += 1;
            if (higherbound < 0)
                return false;
            lowerbound = max(0, lowerbound);
        }
        return lowerbound == 0;
    }
};

// Input: "(*))"
// Output: True
// Input: "(*)"
// Output: True

int main(int argc, char const *argv[]) {
    Solution sol;
    vector<string> testset = {"(*))",   "(*)",  "",       "((*)",   "((***",
                              "((()))", "(*()", "((()*)", "*****(", "())*"};
    for (auto test : testset)
        cout << sol.checkValidString(test) << endl;
    return 0;
}
