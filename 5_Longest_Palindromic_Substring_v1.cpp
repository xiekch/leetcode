#include <iostream>
#include <string>
using namespace std;
// BF
class Solution {
  public:
    string longestPalindrome(string s) {
        int n = s.length();
        int r = 0, len = 0, maxlen = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            if (i % 2 == 0) {
                len = 1;
                for (int start = i - 2, end = i + 2;
                     start >= 0 && end < 2 * n - 1;
                     start -= 2, end += 2, len += 2) {
                    if (s[start / 2] != s[end / 2])
                        break;
                }
            } else {
                len = 0;
                for (int start = i - 1, end = i + 1;
                     start >= 0 && end < 2 * n - 1;
                     start -= 2, end += 2, len += 2) {
                    if (s[start / 2] != s[end / 2])
                        break;
                }
            }
            if (len > maxlen) {
                r = (i + 1) / 2 - len / 2;
                maxlen = len;
            }
        }

        return s.substr(r, maxlen);
    }
};

int main() {
    Solution s;
    cout << s.longestPalindrome("babad") << endl;

    return 0;
}