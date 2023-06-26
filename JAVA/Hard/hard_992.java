package JAVA.Hard;

public class hard_992 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;

        System.out.println(MostK(nums, k) - MostK(nums, k - 1));
    }

    public static int MostK(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        int count = 0;
        int[] freq = new int[n + 1];
        for (int right = 0, left = 0; right < n; right++) {
            if (freq[nums[right]]++ == 0)
                count++;

            while (count > k) {
                if (--freq[nums[left++]] == 0)
                    count--;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}

// int n = nums.length;
// int[] pos = new int[n + 1];// num-->rightest pos
// Arrays.fill(pos, -1);
// int ans = 0, size = 0, left = 0, right = -1;
// while (++right < n) {
// if (pos[nums[right]] < left) {// 新数字不在滑动窗口中
// size++;
// if (size > k) {// 不同的数字超了
// left = pos[nums[left]] + 1;// 选择下一个不同的数字
// size--;
// }
// } else {// 新数字在滑动窗口中

// }
// pos[nums[right]] = right;// 记录当前数字最右侧位置
// if (size == k) {
// int cur = left;
// while (pos[nums[cur]] != cur)
// cur++;
// ans += cur - left + 1;
// }
// }
// System.out.println(ans);