package JAVA.Mid;

public class mid_861 {

    static int[][] grid = {
            { 0, 0, 1, 1 },
            { 1, 0, 1, 0 },
            { 1, 1, 0, 0 } };
    static int m = grid.length, n = grid[0].length;

    public static void main(String[] args) {
        for (int row = 0; row < m; row++) {
            if (grid[row][0] == 0)
                filpRow(row);
        }
        for (int col = 1; col < n; col++) {
            int sum = 0;
            for (int row = 0; row < m; row++)
                sum += grid[row][col];
            if (m - sum > sum)
                filpCol(col);
        }
        int ans = 0;
        for (int col = 0; col < n; col++) {
            int sum = 0;
            for (int row = 0; row < m; row++)
                sum += grid[row][n - 1 - col];
            ans += sum * Math.pow(2, col);
        }
        System.out.println(ans);
    }

    public static void filpRow(int r) {
        for (int col = 0; col < n; col++)
            grid[r][col] = 1 - grid[r][col];
    }

    public static void filpCol(int c) {
        for (int row = 0; row < m; row++)
            grid[row][c] = 1 - grid[row][c];
    }
}
