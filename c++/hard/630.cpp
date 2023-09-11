#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main(int argc, char const* argv[])
{
    vector<vector<int>> courses = { {100, 200} ,{200, 1300},{1000, 1250},{2000, 3200} };
    sort(courses.begin(), courses.end(),
        [&](const vector<int>& a, const vector<int>& b)->bool {return  a[1] < b[1];});
    priority_queue<int> queue;
    int total = 0;
    for (vector<int>& c : courses) {
        if (total + c[0] <= c[1]) {
            queue.push(c[0]);
            total += c[0];
        }
        else if (!queue.empty() && c[0] < queue.top()) {
            total -= queue.top();
            queue.pop();
            total += c[0];
            queue.push(c[0]);
        }
    }
    cout << queue.size() << endl;
    return 0;
}
