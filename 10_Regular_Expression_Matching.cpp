#include <string>
using namespace std;
// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.

// "" "" true
// aa a false
// aab c*a*b true
// ab .*  true
// mississippi mis*is*p*. false
// aaaaa a.*aa true

// recursion
// find the logic(state transitions)!
class Solution {
  public:
    bool isMatch(string s, string p) {
        if (p.empty()) {
            return s.empty() ? true : false;
        }

        bool firstMatch = (!s.empty()) && (s[0] == p[0] || p[0] == '.');

        if (p.size() >= 2 && p[1] == '*') {
            return (firstMatch && isMatch(s.substr(1), p)) ||
                   (isMatch(s, p.substr(2)));
        } else
            return (firstMatch && isMatch(s.substr(1), p.substr(1)));
    }
};