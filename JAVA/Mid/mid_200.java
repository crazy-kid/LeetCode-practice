import java.util.Arrays;
import java.util.HashSet;

public class mid_200 {

    public static int n;
    public static int m;
    public static int[] p;

    public static void main(String[] args) {
        char[][] grid = { { '1', '0', '1', '1', '1' },
                { '1', '0', '1', '0', '1' },
                { '1', '1', '1', '0', '1' } };

        m = grid.length;
        n = grid[0].length;
        p = new int[m * n];
        Arrays.fill(p, -1);
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1') {
                    p[n * row + col] = n * row + col;
                }
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (p[n * row + col] > -1) {
                    if (row - 1 >= 0 && p[n * (row - 1) + col] > -1)
                        union(n * row + col, n * (row - 1) + col);
                    if (row + 1 < m && p[n * (row + 1) + col] > -1)
                        union(n * row + col, n * (row + 1) + col);
                    if (col - 1 >= 0 && p[n * row + col - 1] > -1)
                        union(n * row + col, n * row + col - 1);
                    if (col + 1 < n && p[n * row + col + 1] > -1)
                        union(n * row + col, n * row + col + 1);
                }
            }
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (p[n * row + col] > -1) {
                    p[n * row + col] = find(p[n * row + col]);
                    set.add(p[n * row + col]);
                }
            }
        }
        System.out.println(set.size());
    }

    public static int find(int num) {
        if (p[num] != num) {
            p[num] = find(p[num]);
        }
        return p[num];
    }

    public static void union(int i1, int i2) {
        int n1 = find(i1);
        int n2 = find(i2);
        if (n1 == n2)
            return;
        if (n1 < n2)
            p[n2] = n1;
        else
            p[n1] = n2;
    }

    public static int[] num2index(int num) {
        int c = (num - 1) % n;
        int r = (num - 1 - c) / n;
        int[] ret = { r, c };
        return ret;
    }
}
