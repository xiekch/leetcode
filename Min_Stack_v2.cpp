#include <iostream>
#include <stack>
using namespace std;
class MinStack {
    stack<int> st;
    stack<int> minimal;

  public:
    /** initialize your data structure here. */
    MinStack() {}

    void push(int x) {
        if (st.size() == 0 || getMin() >= x) {
            minimal.push(x);
        }
        st.push(x);
    }

    void pop() {
        if (st.size() == 0)
            return;
        if (st.top() == getMin()) {
            minimal.pop();
        }
        st.pop();
    }

    int top() { return st.top(); }

    int getMin() { return minimal.top(); }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */

int main(int argc, char const *argv[]) {
    MinStack minStack;
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    cout << minStack.getMin() << endl; // Returns - 3.
    minStack.pop();
    cout << minStack.top() << endl;    // Returns 0.
    cout << minStack.getMin() << endl; // Returns -2.
    minStack.pop();
    minStack.pop();
    minStack.push(-3);
    cout << minStack.getMin() << endl; // Returns - 3.

    return 0;
}
