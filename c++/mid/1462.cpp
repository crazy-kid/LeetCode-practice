#include <iostream>
#include <vector>
#include <unordered_set>
#include <queue>

using namespace std;

int numCourses;

void bfs(int node, const unordered_set<int> graph[], vector<unordered_set<int>>& isPre);

int main(int argc, char const* argv[])
{
    /* code */
    numCourses = 2;
    vector<vector<int>> prerequisites = { {1,0} };
    vector<vector<int>> queries = { {0,1},{1,0} };

    vector<int> count(numCourses);
    unordered_set<int> graph[numCourses];
    vector<unordered_set<int>> isPre(numCourses, unordered_set<int>());
    for (const vector<int>& edge : prerequisites) {
        graph[edge[0]].insert(edge[1]);
        count[edge[1]]++;
    }
    for (int i = 0;i < numCourses;i++) {
        if (count[i] > 0) continue;
        bfs(i, graph, isPre);
    }
    vector<bool> ans;
    for (int i = 0;i < queries.size();i++) {
        int x = queries[i][0], y = queries[i][1];
        if (isPre[x].find(y) != isPre[x].end()) ans.push_back(true);
        else ans.push_back(false);
    }
    for (bool b : ans) {
        cout << b << " ";
    }
    return 0;
}

void bfs(int node, const unordered_set<int> graph[], vector<unordered_set<int>>& isPre) {
    for (int child : graph[node]) {
        if (isPre[child].empty())
            bfs(child, graph, isPre);
        isPre[node].insert(isPre[child].begin(), isPre[child].end());
    }
    isPre[node].insert(node);
}

