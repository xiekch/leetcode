#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    int myAtoi(string s) {
        long res = 0;
        int sign = 1;
        int cur = 0;

        while (cur < s.length() && s[cur] == ' ') cur++;
        if (s[cur] == '-') {
            sign = -1;
            cur++;
        } else if (s[cur] == '+')
            cur++;

        for (; cur < s.length() && s[cur] >= '0' && s[cur] <= '9'; cur++) {
            char ch = s[cur];
            int digit = ch - '0';
            res = res * 10 + digit;
            // cout << res << endl;
            if (sign * res > INT32_MAX)
                return INT32_MAX;
            if (sign * res < INT32_MIN)
                return INT32_MIN;
        }
        return sign * res;
    }
};

int main(int argc, char const *argv[]) {
    Solution solution;
    string testCases[] = {"25", "  25", "-25", "  -25 j", "4193 with words",
                          "words and 987", "-91283472332", "22233334455",
                          "--225", "++222", "00000-42a1234",
                          "   +0 123"};
    for (string testCase : testCases) {
        cout << solution.myAtoi(testCase) << endl;
    }
    return 0;
}
