#include <iostream>
#include <stack>
#include <string>
#include <vector>
using namespace std;
// '*' could be treated as a single right parenthesis ')' or a single left
// parenthesis '(' or an empty string.
class Solution {
  public:
    bool checkValidString(string s) {
        if (s.empty())
            return true;
        vector<int> asterisks;
        stack<int> st;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '*')
                asterisks.push_back(i);
            else if (s[i] == '(')
                st.push(i);
            else if (s[i] == ')') {
                if (st.empty() && asterisks.empty())
                    return false;
                else if (!st.empty() && s[st.top()] == '(')
                    st.pop();
                else if (asterisks.size() > 0)
                    asterisks.pop_back();
            }
        }
        for (int i = asterisks.size() - 1; !st.empty() && i >= 0; i--) {
            if (st.top() < asterisks[i])
                st.pop();
        }

        return st.empty();
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
