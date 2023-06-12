package JAVA.Mid;

public class mid_1314 {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int k = 1;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int row = 1; row < m + 1; row++) {
            for (int col = 1; col < n + 1; col++) {
                preSum[row][col] = preSum[row][col - 1] + preSum[row - 1][col] - preSum[row - 1][col - 1]
                        + matrix[row - 1][col - 1];
            }
        }

        int[][] ans = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int left = Math.max(0, col - k);
                int right = Math.min(n - 1, col + k);
                int up = Math.max(0, row - k);
                int down = Math.min(m - 1, row + k);
                ans[row][col] = preSum[down + 1][right + 1] + preSum[up][left] - preSum[up][right + 1]
                        - preSum[down + 1][left];
            }
        }
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(ans[row][col] + " ");
            }
            System.out.println();
        }
    }
}
