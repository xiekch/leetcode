#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {

  public:
    vector<string> letterCombinations(string digits) {
        vector<string> res;
        string suffix, prefix;
        string suffixes[] = {"",    "",    "abc",  "def", "ghi",
                             "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.size(); i++) {
            int curSize = res.size();
            suffix = suffixes[digits[i] - '0'];
            if (curSize == 0) {
                prefix = "";
                for (int j = 0; j < suffix.size(); j++) {
                    res.push_back(prefix + suffix[j]);
                }
            } else
                for (int i = 0; i < curSize; i++) {
                    prefix = res[i];
                    res[i] = res[i] + suffix[0];
                    for (int j = 1; j < suffix.size(); j++) {
                        res.push_back(prefix + suffix[j]);
                    }
                }
        }

        return res;
    }
};

int main(int argc, char const *argv[]) {
    Solution solution;
    auto ans = solution.letterCombinations("23");
    for (auto i : ans) {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}
