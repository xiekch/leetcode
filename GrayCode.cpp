#include <cmath>
#include <iostream>
#include <vector>
using namespace std;

class Solution {
  public:
    vector<int> grayCode(int n) {
        vector<int> result;
        result.push_back(0);
        for (int i = 0; i < n; i++) {
            int before = pow(2, i), after = pow(2, i + 1);
            for (int j = 1; j <= before; j++) {
                result.push_back(result[before - j] + before);
            }
        }

        return result;
    }
};

int main() {
    Solution s;
    vector<int> v = s.grayCode(3);
    for (int i = 0; i < v.size(); i++) {
        cout << v[i] << endl;
    }
}