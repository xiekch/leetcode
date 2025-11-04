#include <iostream>
#include <queue>
#include <string>
using namespace std;

class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        priority_queue<pair<int, char>> pq;
        if (a > 0)
            pq.emplace(a, 'a');
        if (b > 0)
            pq.emplace(b, 'b');
        if (c > 0)
            pq.emplace(c, 'c');
        string happyString = "";
        while (!pq.empty()) {
            auto first = pq.top();
            pq.pop();
            int firstNum = first.first;
            char firstChar = first.second;
            if (happyString.length() < 2 ||
                (happyString.length() >= 2 &&
                 happyString.substr(happyString.length() - 2, 2) != (string("") + firstChar + firstChar))) {
                happyString += firstChar;
                firstNum -= 1;
            } else if (!pq.empty()) {
                auto second = pq.top();
                pq.pop();
                int secondNum = second.first;
                char secondChar = second.second;
                happyString += secondChar;
                secondNum -= 1;
                if (secondNum > 0) {
                    pq.emplace(secondNum, secondChar);
                }
                // cout << happyString << firstNum << " " << endl;
            } else {
                break;
            }
            if (firstNum > 0) {
                pq.emplace(firstNum, firstChar);
            }
        }
        return happyString;
    }
};

int main() {
    Solution sol;
    cout << sol.longestDiverseString(1, 1, 7) << endl;
    cout << sol.longestDiverseString(7, 1, 0) << endl;
    cout << sol.longestDiverseString(4, 2, 1) << endl;
    cout << sol.longestDiverseString(10, 100, 70) << endl;
}