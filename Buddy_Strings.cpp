#include <iostream>
#include <string>
using namespace std;
class Solution {
public:
    bool buddyStrings(string s, string goal) {
        if (s.size() != goal.size())
            return false;
        int count = 0, index = -1, lastIndex = -1;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] != goal[i]) {
                lastIndex = index;
                index = i;
                count++;
            }
        }
        if (count == 2 && s[lastIndex] == goal[index] && s[index] == goal[lastIndex]) {
            return true;
        }
        if (count == 0) {
            int a[26] = {0};
            for (int i = 0; i < s.size(); i++) {
                a[s[i] - 'a']++;
                if (a[s[i] - 'a'] >= 2)
                    return true;
            }
        }
        return false;
    }
};

int main(int argc, char const *argv[]) {
    Solution solution;
    int a[2] = {};
    string testCases[][2] = {{"ab", "ab"}, {"aa", "aa"}, {"aaaaaaabc", "aaaaaaacb"}};
    for (auto testCase : testCases) {
        cout << solution.buddyStrings(testCase[0], testCase[1]) << endl;
    }
    return 0;
}
