#include <cmath>
#include <iostream>
#include <vector>
using namespace std;

class Solution {
    vector<int> nums;
    vector<int> cur;

public:
    Solution(vector<int> &nums) {
        this->nums = nums;
        this->cur = nums;
    }

    vector<int> reset() {
        cur = nums;
        return cur;
    }

    vector<int> shuffle() {
        for (int i = 0; i < cur.size(); i++) {
            int randint = i + rand() % (cur.size() - i);
            swap(cur[i], cur[randint]);
        }
        return cur;
    }
};

int main(int argc, char const *argv[]) {
    vector<int> v = {1, 2, 3, 4, 5};
    Solution solution(v);
    for (int i = 0; i < 5; i++) {
        vector<int> a = solution.shuffle();
        for (int j = 0; j < a.size(); j++) {
            cout << a[j];
        }
        cout << endl;
    }
    return 0;
}
