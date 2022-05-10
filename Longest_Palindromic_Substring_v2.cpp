#include <iostream>
#include <string>
#include <vector>
using namespace std;
// Manacher's Algorithm
class Solution {
public:
    string longestPalindrome(string s) {
        if (s.size() == 0)
            return "";
        string str = "#";
        for (char ch : s) {
            str += ch;
            str += "#";
        }
        // radius
        vector<int> p(str.size(), 0);
        int maxlen = 0, mid = 0;
        int mright = 0, id = 0;
        for (int i = 1; i < str.size() - 1; i++) {
            if (i < mright) {
                p[i] = min(mright - i, p[2 * id - i]);
            } else
                p[i] = 1;

            while (i - p[i] >= 0 && i + p[i] < str.size() &&
                   str[i - p[i]] == str[i + p[i]]) {
                p[i]++;
            }

            if (p[i] + i > mright) {
                mright = p[i] + i;
                id = i;
            }
            if (p[i] > maxlen) {
                maxlen = p[i];
                mid = i;
            }
        }
        return s.substr((mid - maxlen + 1) / 2, maxlen - 1);
    }
};

int main(int argc, char const *argv[]) {
    Solution sol;
    string testset[] = {"babad", "aa", "cbbd", "baaaaaaab", "a", "babadada"};
    for (auto test : testset)
        cout << sol.longestPalindrome(test) << endl;
    return 0;
}
