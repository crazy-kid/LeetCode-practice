package JAVA.Mid;

public class mid_1605 {

    public static void main(String[] args) {
        int[] rowSum = { 5, 7, 10 };
        int[] colSum = { 8, 6, 8 };

        int m = rowSum.length, n = colSum.length;
        int[][] ans = new int[m][n];
        for (int col = 0; col < n; col++) {
            ans[0][col] = colSum[col];
        }
        for (int row = 0; row < m - 1; row++) {
            int sum = rowSum[row];
            for (int col = 0; col < n; col++) {
                int left = Math.min(ans[row][col], sum);
                ans[row + 1][col] += ans[row][col] - left;
                sum -= left;
                ans[row][col] = left;
            }
        }
        for (int[] row : ans) {
            for (int num : row)
                System.out.print(num + " ");
            System.out.println();
        }
    }
}
