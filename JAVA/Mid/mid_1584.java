package JAVA.Mid;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mid_1584 {

    public static void main(String[] args) {
        int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };

        int n = points.length;
        PriorityQueue<int[]> edges = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int len1 = len(o1[0], o1[1], points);
                int len2 = len(o2[0], o2[1], points);
                return len1 - len2;
            }
        });

        boolean[] isVisit = new boolean[n];
        isVisit[0] = true;
        for (int end = 1; end < n; end++) {
            edges.add(new int[] { 0, end });
        }

        int count = 0;
        int ans = 0;
        while (count < n - 1) {
            int[] candidate = edges.poll();
            int newNode;
            if (isVisit[candidate[0]] & isVisit[candidate[1]])// 边的两端均被访问过
                continue;
            if (!isVisit[candidate[0]])
                newNode = candidate[0];
            else
                newNode = candidate[1];
            isVisit[newNode] = true;
            for (int i = 0; i < n; i++) {
                if (!isVisit[i])
                    edges.add(new int[] { newNode, i });
            }
            ans += len(candidate[0], candidate[1], points);
            count++;
        }

        System.out.println(ans);
    }

    public static int len(int start, int end, int[][] points) {
        return Math.abs(points[start][0] - points[end][0]) + Math.abs(points[start][1] - points[end][1]);
    }
}
