package JAVA.Hard;

import java.util.Arrays;
import java.util.Stack;

public class hard_84 {

    public static void main(String[] args) {
        int[] heights = { 1, 2, 2, 5, 6, 2, 3 };

        int n = heights.length;
        int[] left = new int[n];
        Arrays.fill(left, -1);
        int[] right = new int[n];
        Arrays.fill(right, n);
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                right[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                if (heights[stack.peek()] < heights[i])
                    left[i] = stack.peek();
                else
                    left[i] = left[stack.peek()];
            } else
                left[i] = -1;
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = left[i] + 1, r = right[i] - 1;
            ans = Math.max(ans, (r - l + 1) * heights[i]);
        }
        System.out.println(ans);
    }
}
