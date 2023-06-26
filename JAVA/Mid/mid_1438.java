package JAVA.Mid;

import java.util.Deque;
import java.util.LinkedList;

public class mid_1438 {

    public static void main(String[] args) {
        int[] nums = { 4, 10, 2, 1, 6 };
        int limit = 10;// 4

        int n = nums.length;
        Deque<Integer> minqueue = new LinkedList<Integer>();
        Deque<Integer> maxqueue = new LinkedList<Integer>();
        int left = 0, right = -1, minIndex = 0, maxIndex = 0, ans = 0;
        while (++right < n) {
            while (!maxqueue.isEmpty() && nums[maxqueue.peekLast()] < nums[right]) {
                maxqueue.pollLast();
            }
            while (!minqueue.isEmpty() && nums[minqueue.peekLast()] > nums[right]) {
                minqueue.pollLast();
            }
            maxqueue.addLast(right);
            minqueue.addLast(right);
            minIndex = minqueue.peekFirst();
            maxIndex = maxqueue.peekFirst();
            while (nums[maxIndex] - nums[minIndex] > limit) {
                if (nums[left] == nums[maxIndex]) {
                    maxqueue.pollFirst();
                    maxIndex = maxqueue.peekFirst();
                }
                if (nums[left] == nums[minIndex]) {
                    minqueue.pollFirst();
                    minIndex = minqueue.peekFirst();
                }
                left++;
            }
            ans = Math.max(right - left + 1, ans);
        }
        System.out.println(ans);
    }
}
