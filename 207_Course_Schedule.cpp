#include <iostream>
#include <set>
#include <stack>
#include <vector>
using namespace std;

// Some courses may have prerequisites, for example to take course 0 you have to
// first take course 1, which is expressed as a pair: [0,1]
// Given the total number of courses and a list of prerequisite pairs, is it
// possible for you to finish all courses?

// cycle detection
// topological sort
class Solution {
  public:
    bool canFinish(int numCourses, vector<vector<int>> &prerequisites) {
        vector<vector<int>> graph(numCourses, vector<int>());
        vector<int> indegree(numCourses, 0);
        for (int i = 0; i < prerequisites.size(); i++) {
            graph[prerequisites[i][0]].push_back(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }

        // loops at most numCourses times
        for (int i = 0; i < numCourses; i++) {
            int j;
            for (j = 0; j < numCourses; j++) {
                if (indegree[j] == 0)
                    break;
            }
            // find no node to remove, i.e. a cycle exists
            if (j == numCourses)
                return false;
            indegree[j] = -1;
            for (int n : graph[j]) {
                indegree[n]--;
            }
        }

        return true;
    }
};

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false

struct Test {
    int num;
    vector<vector<int>> test;
};

int main(int argc, char const *argv[]) {
    Solution sol;

    vector<Test> testset = {{3, {{1, 0}, {2, 0}, {2, 1}}},
                            {3, {{1, 0}, {2, 1}, {0, 2}}},
                            {4, {{0, 1}, {3, 1}, {1, 3}, {3, 2}}}};

    for (auto test : testset) {
        cout << sol.canFinish(test.num, test.test) << endl;
    }
    return 0;
}
