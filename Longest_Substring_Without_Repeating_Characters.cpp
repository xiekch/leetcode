#include <iostream>
#include <set>
#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int left = 0, right = 0, maxLength = 0, curLength = 0;
        set<char> charSet;
        while (right < s.length()) {
            while (charSet.find(s[right]) != charSet.end()) {
                charSet.erase(s[left]);
                left++;
            }

            charSet.insert(s[right]);
            curLength = right - left + 1;
            maxLength = max(maxLength, curLength);
            right++;
            // cout << left << " " << right << " " << curLength << endl;
        }
        return maxLength;
    }
};

int main() {
    vector<string> testCases = {"abcabcbb", "bbbb", "pwwkew", "tmmzuxt"};
    Solution sol;
    for (auto testCase : testCases) {
        cout << sol.lengthOfLongestSubstring(testCase) << endl;
    }
    return 0;
}