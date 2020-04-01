#include <iostream>
#include <set>
#include <string>
#include <vector>
using namespace std;
// Given a non-empty string s and a dictionary wordDict containing a list of
//  non-empty words, determine if s can be segmented into a space-separated
//  sequence of one or more dictionary words.
// https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways
class Solution {
  public:
    bool wordBreak(string s, vector<string> &wordDict) {
        set<string> dict;
        for (string i : wordDict) {
            dict.insert(i);
        }
        // matched[i] stands for whether subarray(0, i) can be segmented into words from the dictionary.
        vector<bool> matched(s.size() + 1, false);
        matched[0] = true;
        for (int i = 0; i <= s.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (matched[j] && dict.count(s.substr(j, i - j)) == 1) {
                    matched[i] = true;
                }
            }
        }
        return matched[s.size()];
    }
};

// Input: s = "applepenapple", wordDict = ["apple", "pen"]
// Output: true
// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
// ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
// false
int main(int argc, char const *argv[]) {
    // string s = "applepenapple";
    // vector<string> wordDict = {"apple", "pen"};
    // string s = "catsandog";
    // vector<string> wordDict = {"cats", "dog", "sand", "and", "cat"};
    string s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
               "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
               "aaaaaaaaaaaaaaaaaaaaaaaab";
    vector<string> wordDict = {"a",         "aa",        "aaa",     "aaaa",
                               "aaaaa",     "aaaaaa",    "aaaaaaa", "aaaaaaaa",
                               "aaaaaaaaa", "aaaaaaaaaa"};
    Solution sol;
    cout << sol.wordBreak(s, wordDict) << endl;
    return 0;
}
