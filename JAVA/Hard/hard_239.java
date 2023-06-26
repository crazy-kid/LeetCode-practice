package JAVA.Hard;

import java.util.Deque;
import java.util.LinkedList;

public class hard_239 {

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        Deque<Integer> queue = new LinkedList<Integer>();// 其实是个单调栈
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (i >= k - 1)
                ans[i - k + 1] = nums[queue.peekFirst()];
        }

        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
