package JAVA.Hard;

import java.util.Deque;
import java.util.LinkedList;

public class hard_683 {

    public static void main(String[] args) {
        int[] bulbs = { 6, 5, 8, 9, 7, 1, 10, 2, 3, 4 };// day-->pos
        int k = 2;

        int n = bulbs.length;
        int[] days = new int[n];// pos-->day
        for (int i = 0; i < n; i++) {
            days[bulbs[i] - 1] = i;
        }

        int ans = n;
        Deque<Integer> dqueue = new LinkedList<Integer>();// 存储pos
        for (int i = 0; i < n - 1; i++) {
            while (!dqueue.isEmpty() && dqueue.peekFirst() < i - k + 1) {
                dqueue.pollFirst();
            }
            while (!dqueue.isEmpty() && days[dqueue.peekLast()] >= days[i]) {
                dqueue.pollLast();
            }
            int curMin = Integer.MAX_VALUE;
            if (k != 0) {
                dqueue.addLast(i);
                curMin = days[dqueue.getFirst()];
            }
            if (i - k >= 0 && days[i - k] < curMin & days[i + 1] < curMin)
                ans = Math.min(ans, Math.max(days[i + 1], days[i - k]));
        }

        System.out.println(ans + 1);
    }
}
