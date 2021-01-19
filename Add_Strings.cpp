#include <algorithm>
#include <iostream>
#include <string>
using namespace std;

class Solution {
  public:
    string addStrings(string num1, string num2) {
        string res;

        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry == 1; i--, j--) {
            char ch = carry + (i < 0 ? 0 : num1[i] - '0') +
                      (j < 0 ? 0 : num2[j] - '0') + '0';
            if (ch > '9') {
                ch -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            res += ch;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};

int main(int argc, char const *argv[]) {
    Solution sol;
    string testset[][2] = {
        {"0", "0"}, {"211", "99"}, {"99999", "1"}, {"992", "2"}};
    for (auto test : testset) {
        cout << sol.addStrings(test[0], test[1]) << endl;
    }

    return 0;
}
