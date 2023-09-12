#include <vector>
#include <unordered_set>
#include <deque>

using namespace std;

bool canFinish(int, vector<vector<int>>&);

int main(int argc, char const* argv[])
{
    /* code */
    return 0;
}

bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
    vector<int> count(numCourses, 0);
    unordered_set<int> graph[numCourses];
    for (vector<int> edge : prerequisites) {
        int pre = edge[1];
        int next = edge[0];
        count[next]++;
        graph[pre].insert(next);
    }
    deque<int> queue;
    for (int i = 0;i < numCourses;i++) {
        if (count[i] == 0)
            queue.push_back(i);
    }
    while (!queue.empty()) {
        int size = queue.size();
        for (int i = 0;i < size;i++) {
            int pre = queue.front();
            queue.pop_front();
            for (int next : graph[pre]) {
                if (--count[next] == 0)
                    queue.push_back(next);
            }
        }
    }
    for (int i : count)
        if (i > 0) return false;
    return true;
}