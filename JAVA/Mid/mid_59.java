package JAVA.Mid;

public class mid_59 {

    public static void main(String[] args) {
        int n = 3;

        int[][] matrix = new int[n][n];
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[] p = { 0, -1 };
        int d = 0;
        for (int i = 1; i <= n * n; i++) {
            int[] next = { p[0] + dir[d][0], p[1] + dir[d][1] };
            if (next[0] < 0 | next[0] >= n | next[1] < 0 | next[1] >= n || matrix[next[0]][next[1]] > 0) {
                d = (d + 1) % 4;
                next[0] = p[0] + dir[d][0];
                next[1] = p[1] + dir[d][1];
            }
            p[0] = next[0];
            p[1] = next[1];
            matrix[p[0]][p[1]] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(" " + matrix[i][j]);
            System.out.println();
        }
    }
}
