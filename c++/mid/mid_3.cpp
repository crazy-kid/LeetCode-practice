#include <cstring>
#include <iostream>
#include <unordered_set>

using namespace std;

int main(int argc, char const* argv[])
{
    /* code */
    string s = "abcabcbb";
    int ans = 0;
    unordered_set<char> set;
    int  right = -1;
    for (int left = 0;left < s.length();left++) {
        if (left != 0)
            set.erase(s[left - 1]);
        while (right + 1 < s.length() && !set.count(s[right + 1]))
            set.insert(s[++right]);
        ans = max(ans, right - left + 1);
    }
    cout << ans << endl;
    return 0;
}