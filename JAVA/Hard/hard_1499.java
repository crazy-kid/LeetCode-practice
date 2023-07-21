package JAVA.Hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class hard_1499 {

    static int[][] points = { { 0, 0 }, { 3, 0 }, { 9, 2 } };
    static int k = 3;

    public static void main(String[] args) {
        int ans = Integer.MIN_VALUE;
        Deque<int[]> queue = new ArrayDeque<int[]>();
        for (int[] point : points) {
            if (!queue.isEmpty()) {
                while (!queue.isEmpty() && point[0] - queue.getFirst()[1] > k) {
                    queue.poll();
                }
                if (!queue.isEmpty())
                    ans = Math.max(ans, point[0] + point[1] + queue.getFirst()[0]);
            }
            while (!queue.isEmpty() && queue.getLast()[0] < point[1] - point[0]) {
                queue.removeLast();
            }
            queue.offer(new int[] { point[1] - point[0], point[0] });
        }
        System.out.println(ans);
    }
}
