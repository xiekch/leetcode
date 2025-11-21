#include <iostream>
#include <queue>
#include <vector>
using namespace std;

// 用小顶堆维护前 k 个最大元素，堆顶即为第 k 大元素
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int i : nums) {
            if (pq.size() < k) {
                pq.push(i);
            } else if (pq.top() < i) {
                pq.push(i);
                pq.pop();
            }
        }
        return pq.top();
    }
};

int main() {
    struct TestCase {
        vector<int> nums;
        int k;
    };

    vector<TestCase> testCases = {{{3, 2, 1, 5, 6, 4}, 2}};
    Solution sol;
    for (auto testCase : testCases) {
        cout << sol.findKthLargest(testCase.nums, testCase.k) << endl;
    }
    return 0;
}