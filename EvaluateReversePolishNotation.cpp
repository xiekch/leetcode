#include <stack>
#include <string>
#include <vector>
using namespace std;

class Solution {
  public:
    int evalRPN(vector<string> &tokens) {
        stack<int> operand;
        int a, b;
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens[i] == "+") {
                a = operand.top();
                operand.pop();
                b = operand.top();
                operand.pop();
                operand.push(b + a);
            } else if (tokens[i] == "-") {
                a = operand.top();
                operand.pop();
                b = operand.top();
                operand.pop();
                operand.push(b - a);
            } else if (tokens[i] == "*") {
                a = operand.top();
                operand.pop();
                b = operand.top();
                operand.pop();
                operand.push(b * a);
            } else if (tokens[i] == "/") {
                a = operand.top();
                operand.pop();
                b = operand.top();
                operand.pop();
                operand.push(b / a);
            } else {
                operand.push(stoi(tokens[i]));
                // operand.push(atoi(tokens[i].c_str()));
            }
        }

        return operand.top();
    }
};