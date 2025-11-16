#include <iostream>
#include <vector>
using namespace std;

/*
 如果你在余额最低点的第二天开始观察，那么从这一天开始，
 你的账户余额将永远不会低于零。
 因为你已经度过了最 “穷” 的一天，之后的总收入是正的，余额只会越来越高。
 只要 total gas == total cost，曲线就会连续
 we know if we run out of fuel say at some ith gas station.
 All the gas station between ith and starting point are bad starting point as well.
 So, this means we can start trying at next gas station on the i + 1 station.
*/
class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int n = gas.size();
        int totalLeft = 0;
        int startIndex = 0;
        int currentLeft = 0;
        for (int i = 0; i < n; i++) {
            totalLeft += gas[i] - cost[i];
            currentLeft += gas[i] - cost[i];
            if (currentLeft < 0) {
                currentLeft = 0;
                startIndex = i + 1;
            }
        }

        if (totalLeft < 0) {
            return -1;
        }
        return startIndex;
    }
};

int main() {
    Solution sol;
    struct GasStation {
        vector<int> gas;
        vector<int> consumed;
    };

    vector<GasStation> testCases = {
        {{4}, {5}},
        {{1, 2, 3, 4, 5}, {3, 4, 5, 1, 2}},
        {{2, 3, 4}, {3, 4, 3}},
        {{5, 8, 2, 8}, {6, 5, 6, 6}},
        {{3, 3, 4}, {3, 4, 4}},
        {{3, 1, 1}, {1, 2, 2}}};
    for (auto testCase : testCases) {
        cout << sol.canCompleteCircuit(testCase.gas, testCase.consumed) << endl;
    }
}
