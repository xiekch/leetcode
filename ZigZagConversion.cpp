#include <iostream>
#include <string>
using namespace std;

class Solution {
  public:
    string convert(string s, int numRows) {
        if (numRows == 1)
            return s;
        string answer;
        int cycle = 2 * (numRows - 1), add;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += cycle) {
                answer += s[j];
                add = 2 * (numRows - i - 1);
                // cout<<s[j]<<" "<<answer<<endl;
                if ((j + add < s.length()) && (add != 0) && (add != cycle))
                    answer += s[j + add];
            }
        }

        return answer;
    }
};

int main() {
    Solution s;
    cout << s.convert("A", 1) << endl;
    cout << s.convert("PAYPALISHIRING", 3) << endl; // PAHNAPLSIIGYIR
    cout << s.convert("PAYPALISHIRING", 4) << endl; // PINALSIGYAHRPI
}