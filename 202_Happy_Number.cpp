#include <iostream>
#include <set>
using namespace std;
class Solution {
  public:
    bool isHappy(int n) {
        set<int> s;
        while (true) {
            s.insert(n);
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            // cout << sum << endl;
            if (sum == 1)
                return true;
            if (s.count(sum) == 1) {
                return false;
            }
            n = sum;
        }
    }
};

// Those numbers for which this process ends in 1 are happy numbers.
// Input: 19
// Output: true
// Explanation:
// 12 + 92 = 82
// 82 + 22 = 68
// 62 + 82 = 100
// 12 + 02 + 02 = 1
int main(int argc, char const *argv[]) {
    Solution sol;
    cout << sol.isHappy(1) << endl;
    return 0;
}
