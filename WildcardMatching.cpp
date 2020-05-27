#include <cstring>
#include <iostream>
#include <string>
using namespace std;

class Solution {
  public:
    bool isMatch(string s, string p) {
        int si = 0, pi = 0, starMatch = -1, match = 0;
        while (si < s.size()) {
            if (pi < p.size() && (p[pi] == '?' || s[si] == p[pi])) {
                si++, pi++;
            } else if (pi < p.size() && p[pi] == '*') {
                starMatch = pi;
                match = si;
                pi++;
            } else if (starMatch != -1) { // retry
                pi = starMatch + 1;
                match++;
                si = match;
            } else {
                return false;
            }
        }
        while (pi < p.size() && p[pi] == '*')
            pi++;
        return pi == p.size();
    }
};

int main() {
    Solution sol;
    string s, p;
    cin >> s >> p;
    cout << sol.isMatch(s, p) << endl;
}