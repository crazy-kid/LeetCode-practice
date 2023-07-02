package JAVA.Mid;

import java.util.LinkedList;
import java.util.Queue;

public class mid_1306 {

    public static void main(String[] args) {
        int[] arr = { 0, 3, 0, 6, 3, 3, 4 };
        int start = 6;

        int n = arr.length;
        boolean[] reachable = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            reachable[index] = true;
            if (index - arr[index] >= 0 && !reachable[index - arr[index]])
                queue.add(index - arr[index]);
            if (index + arr[index] < n && !reachable[index + arr[index]])
                queue.add(index + arr[index]);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0 & reachable[i])
                return;
        }
        System.out.println(false);
    }
}
