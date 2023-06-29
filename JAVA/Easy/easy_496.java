package JAVA.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class easy_496 {

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };

        int n1 = nums1.length;
        int n2 = nums2.length;
        HashMap<Integer, Integer> num2index = new HashMap<Integer, Integer>();
        for (int i = 0; i < n1; i++) {
            num2index.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<Integer>();
        int[] ans = new int[n1];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n2; i++) {
            if (stack.isEmpty() || nums2[i] < stack.peek()) {
                stack.push(nums2[i]);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int top = stack.pop();
                if (num2index.containsKey(top)) {
                    ans[num2index.get(top)] = nums2[i];
                }
            }
            stack.push(nums2[i]);
        }

        for (int i : ans)
            System.out.println(i);
    }
}