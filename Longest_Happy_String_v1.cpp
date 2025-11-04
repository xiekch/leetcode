#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        int firstNum = a, secondNum = b, thirdNum = c;
        char firstChar = 'a', secondChar = 'b', thirdChar = 'c';
        if (thirdNum > secondNum) {
            swap(thirdChar, secondChar);
            swap(thirdNum, secondNum);
        }
        if (secondNum > firstNum) {
            swap(firstChar, secondChar);
            swap(firstNum, secondNum);
        }
        if (thirdNum > secondNum) {
            swap(thirdChar, secondChar);
            swap(thirdNum, secondNum);
        }

        return generate(firstNum, secondNum, thirdNum, firstChar, secondChar, thirdChar);
    }

    string generate(int& firstNum, int& secondNum, int& thirdNum,
                    char firstChar, char secondChar, char thirdChar) {
        // cout<< firstChar<<secondChar<<thirdChar<<endl;
        string happyString = "";
        while (firstNum > 0) {
            if (happyString.length() < 2 ||
                (happyString.length() >= 2 &&
                 happyString.substr(happyString.length() - 2, 2) != (string("") + firstChar + firstChar))) {
                happyString += firstChar;
                firstNum -= 1;
            } else {
                if (secondNum > 0) {
                    happyString += secondChar;
                    secondNum -= 1;
                } else {
                    break;
                }
            }
            // cout << happyString << firstNum << " " << secondNum << " " << thirdNum << endl;

            if (thirdNum > secondNum) {
                swap(secondChar, thirdChar);
                swap(secondNum, thirdNum);
            }
            if (secondNum > firstNum) {
                swap(firstChar, secondChar);
                swap(firstNum, secondNum);
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