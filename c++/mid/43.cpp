#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

string stringAdd(const string num1, const string num2);
string stringMul(const string num, int m, int zeros);

int main(int argc, char const* argv[])
{
    string num1 = "9311";
    string num2 = "0";
    string ans = "";
    for (int i = 0;i < num2.length();i++) {
        string tmp = stringMul(num1, num2[num2.length() - 1 - i] - '0', i);
        ans = stringAdd(ans, tmp);
    }
    cout << ans << endl;
    return 0;
}

string stringAdd(const string num1, const string num2) {
    string ans = "";
    int carry = 0, cur1 = num1.length() - 1, cur2 = num2.length() - 1;
    while (cur1 >= 0 || cur2 >= 0 || carry > 0) {
        int a = cur1 >= 0 ? num1[cur1] - '0' : 0;
        int b = cur2 >= 0 ? num2[cur2] - '0' : 0;
        int c = (a + b + carry) % 10;
        carry = (a + b + carry) / 10;
        ans += char(c + '0');
        cur1--;
        cur2--;
    }
    reverse(ans.begin(), ans.end());
    return ans;
};

string stringMul(const string num, int m, int zeros) {
    string ans = "";
    if (m == 0 || num == "0") return "0";
    int carry = 0, cur = num.length() - 1;
    while (carry > 0 || cur >= 0) {
        int a = cur >= 0 ? num[cur] - '0' : 0;
        int d = (a * m + carry) % 10;
        carry = (a * m + carry) / 10;
        ans += char(d + '0');
        cur--;
    }
    reverse(ans.begin(), ans.end());
    for (int i = 0;i < zeros;i++)
        ans += '0';
    return ans;
};