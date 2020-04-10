#include <iostream>
#include <string>
#include <vector>
using namespace std;
class Solution {
  public:
    bool backspaceCompare(string S, string T) {
        string ss, tt;
        for (char i : S) {
            if (i == '#' && ss.size() > 0)
                ss.pop_back();
            if (i != '#')
                ss.push_back(i);
        }
        for (char i : T) {
            if (i == '#' && tt.size() > 0)
                tt.pop_back();
            if (i != '#')
                tt.push_back(i);
        }
        return ss == tt;
    }
};

int main(int argc, char const *argv[]) {
    Solution sol;
    vector<vector<string>> testset = {
        {"ab#c", "ad#c"}, {"ab##", "c#d#"}, {"a##c", "#a#c"}, {"a#c", "b"}};
    for (auto test : testset)
        cout << sol.backspaceCompare(test[0], test[1]) << endl;
    return 0;
}
