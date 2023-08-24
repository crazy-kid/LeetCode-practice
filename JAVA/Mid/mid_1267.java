package JAVA.Mid;

public class mid_1267 {

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 1 } };

        int m = grid.length;
        int n = grid[0].length;
        boolean[] rowOne = new boolean[m];
        boolean[] colOne = new boolean[n];
        int total = 0;
        for (int row = 0; row < m; row++) {
            int rowSum = 0;
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    total++;
                    rowSum++;
                }
            }
            if (rowSum == 1)
                rowOne[row] = true;
        }
        for (int col = 0; col < n; col++) {
            int colSum = 0;
            for (int row = 0; row < m; row++)
                if (grid[row][col] == 1)
                    colSum++;
            if (colSum == 1)
                colOne[col] = true;
        }
        int ones = 0;
        for (int row = 0; row < m; row++) {
            if (!rowOne[row])
                continue;
            for (int col = 0; col < n; col++)
                if (grid[row][col] == 1 & colOne[col])
                    ones++;
        }
        System.out.println(total - ones);
    }
}
