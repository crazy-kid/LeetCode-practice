package JAVA.Mid;

import java.util.Arrays;
import java.util.Stack;

public class mid_1856 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 5, 6, 4, 2 };

        final int MOD = (int) 1e10 + 7;
        int n = nums.length;
        long[] preSum = new long[n + 1];// 前缀和及其初始化
        for (int i = 0; i < n; i++)
            preSum[i + 1] = preSum[i] + nums[i];
        int[] right = new int[n];
        Arrays.fill(right, n);
        int[] left = new int[n];
        Arrays.fill(left, -1);
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                right[stack.pop()] = i;
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                left[stack.pop()] = i;
            stack.push(i);
        }

        long ans = 0;
        int l, r;
        for (int i = 0; i < n; i++) {
            l = left[i] + 1;
            r = right[i] - 1;
            ans = Math.max(ans, (preSum[r + 1] - preSum[l]) * nums[i]);
        }
        System.out.println((int) (ans % MOD));
    }
}
