package JAVA.Mid;

import java.util.Arrays;
import java.util.Comparator;

public class mid_452 {

    public static void main(String[] args) {
        int[][] points = { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } };
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] < p2[0])
                    return -1;
                if (p1[0] > p2[0])
                    return 1;
                return 0;
            }
        });
        int right = points[0][1], cur = 0, ans = 1;
        for (cur = 0; cur < points.length; cur++) {
            if (points[cur][0] > right) {
                right = points[cur][1];
                ans++;
            } else if (points[cur][1] < right)
                right = points[cur][1];
        }
        System.out.println(ans);
    }
}
