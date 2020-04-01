#include <iostream>
#include <set>
#include <string>
#include <vector>
using namespace std;
// Given a non-empty string s and a dictionary wordDict containing a list of
//  non-empty words, determine if s can be segmented into a space-separated
//  sequence of one or more dictionary words.
// ERROR Time Limit Exceeded
class Solution {
    set<string> dict;
    bool findWordBreak(string s) {
        if (s.size() == 0)
            return true;
        for (int i = 1; i <= s.size(); i++) {
            if (dict.count(s.substr(0, i)) == 1 && findWordBreak(s.substr(i))) {
                return true;
            }
        }
        return false;
    }

  public:
    bool wordBreak(string s, vector<string> &wordDict) {
        for (string i : wordDict) {
            dict.insert(i);
        }
        return findWordBreak(s);
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
