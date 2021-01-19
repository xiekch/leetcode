#include <cstdlib>
#include <iostream>
#include <queue>
#include <vector>
using namespace std;
class Solution {
  public:
    int lastStoneWeight(vector<int> &stones) {
        if (stones.size() == 0)
            return 0;
        priority_queue<int> qu(stones.begin(),stones.end());
        int top1, top2;
        while (qu.size() > 1) {
            top1 = qu.top();
            qu.pop();
            // cout << top1 << " ";
            top2 = qu.top();
            qu.pop();
            // cout << top2;
            qu.push(abs(top1 - top2));
        }
        return qu.top();
    }
};

int main(int argc, char const *argv[]) {
    vector<int> test = {2, 7, 4, 1, 8, 1};
    // vector<int> test = {2, 7, 4};
    // vector<int> test = {4};
    Solution sol;
    cout << sol.lastStoneWeight(test) << endl;
    return 0;
}
