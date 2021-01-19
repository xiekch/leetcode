// https://leetcode.com/problems/minimum-window-substring/solution/
#include <iostream>
#include <map>
#include <string>
#include <vector>
using namespace std;
// Optimized Sliding Window
// We keep expanding the window by moving the right pointer.
// When the window has all the desired characters, we contract 
// (if possible) and save the smallest window till now.

class Solution {
    bool contain(map<char, int> &tset, map<char, int> &sset) {
        for (auto i : tset) {
            if (sset.find(i.first) == sset.end() || sset[i.first] < i.second) {
                return false;
            }
        }
        return true;
    }

    void addChar(map<char, int> &cset, char ch) {
        if (cset.find(ch) == cset.end()) {
            cset[ch] = 0;
        } else {
            cset[ch]++;
        }
    }

    void removeChar(map<char, int> &cset, char ch) {
        if (cset.find(ch) != cset.end()) {
            cset[ch]--;
        }
    }

  public:
    string minWindow(string s, string t) {
        if (s.empty() || t.empty())
            return "";
        vector<pair<int, char>> filter;
        map<char, int> tset, sset;
        for (int i = 0; i < t.size(); i++) {
            addChar(tset, t[i]);
        }

        for (size_t i = 0; i < s.size(); i++) {
            if (t.find(s[i]) != string::npos) {
                filter.push_back(make_pair(i, s[i]));
            }
        }
        if (filter.empty())
            return "";

        string res = "";
        int start = filter[0].first, end = filter[0].first;
        int lstart = s.size(), rend = 0;
        for (size_t i = 0, j = 0; i < filter.size(); i++) {
            start = filter[i].first;
            addChar(sset, filter[i].second);

            while (contain(tset, sset)) {
                // cout << start << " " << end << " " << lstart << " " << rend
                //      << endl;
                if ((start - end) <= (lstart - rend)) {
                    lstart = start;
                    rend = end;
                    res = s.substr(rend, lstart - rend + 1);
                }
                removeChar(sset, filter[j].second);
                j++;
                if (j < filter.size())
                    end = filter[j].first;
            }
        }

        return res;
    }
};

// BANCDBAB ABCD
// a a
// ab b
// ab c
// abc ac
// adobecodebanc abcda

int main(int argc, char const *argv[]) {
    Solution solution;
    while (true) {
        string s, t;
        cin >> s >> t;
        // string s = "BANCDBAB";
        // string t = "ABCD";
        // cout << s << " " << t << endl;
        string res = solution.minWindow(s, t);
        cout << res << endl;
    }
    return 0;
}
