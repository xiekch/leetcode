// ValidParentheses
#include <string>
using namespace std;

template <typename T> class Stack {
    T *arr;
    int size;
    int maxSize;

  public:
    Stack(int n) {
        arr = new T[n]();
        size = 0;
        maxSize = n;
    }

    ~Stack() { delete[] arr; }

    void push(T c) {
        if (size >= this->maxSize)
            throw "overflow";
        arr[size] = c;
        size++;
    }

    void pop() {
        if (size <= 0)
            throw "underflow";
        size--;
    }

    T top() {
        if (size <= 0)
            throw "underflow";
        return arr[size - 1];
    }

    bool empty() { return size == 0; }
};

class Solution {
  public:
    bool isValid(string s) {
        Stack<char> st(s.length());
        bool valid = true;
        char c;
        for (int i = 0; i < s.length() && valid; i++) {
            c = s[i];
            if (st.empty()) {
                if (c == ')' || c == ']' || c == '}')
                    valid = false;
                else
                    st.push(c);
                continue;
            }
            switch (c) {
            case ')':
                if (st.top() == '(')
                    st.pop();
                else
                    valid = false;
                break;
            case ']':
                if (st.top() == '[')
                    st.pop();
                else
                    valid = false;
                break;
            case '}':
                if (st.top() == '{')
                    st.pop();
                else
                    valid = false;
                break;
            default:
                st.push(c);
                break;
            }
        }

        return valid && st.empty();
    }
};