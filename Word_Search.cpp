#include <iostream>
#include <set>
#include <stack>
#include <string>
#include <vector>
using namespace std;
// search
// DFS
// or recursion
class Solution {
    struct Path {
        int x, y;
        int len;
        // one path one visited
        set<pair<int, int>> visited;
        Path() {}
        Path(int x, int y, int len) : x(x), y(y), len(len) {}
    };

    bool dfs(const vector<vector<char>> &board, int x, int y,
             const string &word) {
        int d[][2] = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        stack<Path> st;
        Path cur(x, y, 1);
        cur.visited.insert(make_pair(x, y));
        st.push(cur);
        int len;
        while (!st.empty()) {
            Path prev = st.top();
            x = st.top().x, y = st.top().y, len = st.top().len;
            st.pop();
            if (len == word.size())
                return true;
            for (int i = 0; i < 4; i++) {
                int nx = x + d[i][0], ny = y + d[i][1];
                if (nx >= 0 && nx < board.size() && ny >= 0 &&
                    ny < board[0].size() && word[len] == board[nx][ny] &&
                    prev.visited.count(make_pair(nx, ny)) == 0) {
                    // cout << board[nx][ny] << " " << nx << " " << ny << endl;
                    Path cur(nx, ny, len + 1);
                    cur.visited = prev.visited;
                    cur.visited.insert(make_pair(nx, ny));
                    st.push(cur);
                }
            }
        }
        return false;
    }

  public:
    bool exist(vector<vector<char>> &board, string word) {
        if (word.size() == 0)
            return true;
        if (board.size() == 0)
            return false;
        multiset<char> s;
        multiset<char> t;
        for (auto i : board) {
            for (auto j : i) {
                s.insert(j);
            }
        }
        for (char i : word) {
            t.insert(i);
        }
        for (char i : word) {
            if (s.count(i) < t.count(i))
                return false;
        }
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                if (board[i][j] == word[0]) {
                    // cout << board[i][j] << " " << i << " " << j << endl;
                    if (dfs(board, i, j, word) == true)
                        return true;
                }
            }
        }
        return false;
    }
};

// board =
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// ESCC
void test1() {
    vector<vector<char>> board = {
        {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    Solution sol;
    cout << sol.exist(board, "ABCCED") << endl;
}

// [["a","a","a","a"],["a","a","a","a"],["a","a","a","a"],["a","a","a","a"],["a","a","a","b"]]
// "aaaaaaaaaaaaaaaaaaaa"
void test2() {
    vector<vector<char>> board = {{'a', 'a', 'a', 'a'},
                                  {'a', 'a', 'a', 'a'},
                                  {'a', 'a', 'a', 'a'},
                                  {'a', 'a', 'a', 'a'},
                                  {'a', 'a', 'a', 'b'}};
    Solution sol;
    cout << sol.exist(board, "aaaaaaaaaaaaaaaaaaaa") << endl;
}

int main(int argc, char const *argv[]) {
    long start = clock();
    test1();
    test2();
    long end = clock();
    cout << end - start << endl;
    return 0;
}
