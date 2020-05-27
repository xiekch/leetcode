#include <cstring>
#include <iostream>
#include <string>
using namespace std;

#define loc(x) (alphabet[x])

class Solution {
  public:
    int lengthOfLongestSubstring(string s) {
        int alphabet[300], length = 0, maxLength = 0;
        memset(alphabet, -1, sizeof(alphabet));
        for (int i = 0, j = -1; i < s.size(); i++) {
            if (loc(s[i]) > j) {
                j = loc(s[i]);
                length = i - j;
            } else
                length++;
            loc(s[i]) = i;
            maxLength = max(length, maxLength);
            // cout<<length<<endl;
        }

        return maxLength;
    }
};

int main() {
    string s = "   ";
    Solution solution;
    cout << "max length: " << solution.lengthOfLongestSubstring(s) << endl;
}