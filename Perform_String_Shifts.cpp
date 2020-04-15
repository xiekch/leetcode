#include <iostream>
#include <string>
#include <vector>
using namespace std;
// shift[i] = [direction, amount]
// direction can be 0 (for left shift) or 1 (for right shift).
class Solution {
  public:
    string stringShift(string s, vector<vector<int>> &shift) {
        if (s.size() <= 1 || shift.size() == 0)
            return s;
        int total = 0;
        for (int i = 0; i < shift.size(); i++) {
            if (shift[i][0] == 1) {
                total += shift[i][1];
            } else {
                total -= shift[i][1];
            }
        }
        if (total < 0) {
            total = -total;
            total %= s.size();
            s = s.substr(total) + s.substr(0, total);
        } else {
            total %= s.size();
            s = s.substr(s.size() - total) + s.substr(0, s.size() - total);
        }

        return s;
    }
};

int main(int argc, char const *argv[]) {
    Solution sol;
    vector<vector<int>> shift = {{0, 1}, {1, 2}};
    string s = sol.stringShift("abcdef", shift);
    cout << s << endl;
    return 0;
}
