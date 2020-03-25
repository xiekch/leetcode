#include <algorithm>
#include <iostream>
#include <map>
#include <string>
#include <vector>
using namespace std;

// Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Output:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// sort and search
class Solution {
  public:
    vector<vector<string>> groupAnagrams(vector<string> &strs) {
        vector<vector<string>> ans;
        map<string, int> indices;
        int count = 0;
        for (auto str : strs) {
            string s = str;
            sort(str.begin(), str.end());
            if (indices.count(str) == 0) {
                indices[str] = count;
                count++;
                ans.push_back(vector<string>());
            }
            int index = indices[str];
            ans[index].push_back(s);
        }
        return ans;
    }
};

int main(int argc, char const *argv[]) {
    vector<string> test = {"eat", "tea", "tan", "ate", "nat", "bat"};
    Solution sol;
    auto ans = sol.groupAnagrams(test);
    for (auto i : ans) {
        for (auto j : i) {
            cout << j << " ";
        }
        cout << endl;
    }
    return 0;
}
