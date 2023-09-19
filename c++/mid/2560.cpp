#include <iostream>
#include <vector>
#include <limits>

using namespace std;

bool valid(const vector<int>& nums, int k, const int max);

int main(int argc, char const* argv[])
{
    vector<int> nums = { 2,7,9,3,1 };
    int k = 2;

    int left = INT32_MAX, right = 0;
    for (int num : nums) {
        left = min(left, num);
        right = max(right, num);
    }
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (valid(nums, k, mid))
            right = mid;
        else left = mid + 1;
    }
    cout << left << endl;
    return 0;
}

bool valid(const vector<int>& nums, int k, const int m)
{
    int dp0[2] = { 0,0 };
    int dp1[2] = { 0,0 };
    dp1[0] = nums[0] <= m ? 1 : 0;
    for (int i = 1;i < nums.size();i++) {
        dp0[1] = max(dp0[0], dp1[0]);
        dp1[1] = nums[i] <= m ? dp0[0] + 1 : 0;
        if (dp0[1] >= k || dp1[1] >= k) return true;
        dp0[0] = dp0[1];
        dp1[0] = dp1[1];
    }
    return false;
}
