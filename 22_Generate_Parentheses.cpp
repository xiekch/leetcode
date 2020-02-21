#include <string>
#include <vector>
using namespace std;

class Solution {
    int n;
    vector<string> res;
    void backtrack(int open, int close, string parenthesis) {
        if (parenthesis.size() == 2 * n) {
            res.push_back(parenthesis);
            return;
        }
        if (open < n) {
            backtrack(open + 1, close, parenthesis + "(");
        }
        if (close < open) {
            backtrack(open, close + 1, parenthesis + ")");
        }
    }

  public:
    vector<string> generateParenthesis(int n) {
        this->n = n;
        backtrack(0, 0, "");
        return this->res;
    }
};