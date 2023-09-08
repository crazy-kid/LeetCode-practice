#include <string>
#include <vector>
#include <iostream>

using namespace std;

int main(int argc, char const* argv[])
{
    /* code */
    string s = "abbxxxxzzy";
    vector<vector<int>> ans;
    int n = s.length();
    int left = 0, right = 0;
    for (right = 0;right < n;right++) {
        if (s[right] != s[left]) {
            if (right - left >= 3)
            {
                vector<int> tmp = { left,right - 1 };
                ans.push_back(tmp);
            }
            left = right;
        }
    }
    if (right - left >= 3)
    {
        vector<int> tmp = { left,right - 1 };
        ans.push_back(tmp);
    }
    for (vector<int> l : ans) {
        cout << l[0] << " " << l[1] << endl;
    }
    return 0;
}
