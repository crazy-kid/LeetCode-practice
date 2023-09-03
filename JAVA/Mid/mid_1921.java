package JAVA.Mid;

import java.util.Arrays;

public class mid_1921 {

    public static void main(String[] args) {
        int[] dist = { 3, 5, 7, 4, 5 };
        int[] speed = { 2, 3, 6, 3, 2 };

        int n = dist.length;
        if (n == 0)
            return;
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = dist[i] / speed[i];
            if (dist[i] % speed[i] == 0)
                rank[i]--;
            rank[i] = Math.max(0, rank[i]);
        }
        Arrays.sort(rank);
        for (int i = 0; i < n; i++)
            if (rank[i] < i) {
                System.out.print(i);
                return;
            }
        System.out.println(n);
    }
}
