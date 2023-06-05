package JAVA.Hard;

import java.util.Arrays;

public class hard_17_24 {

    public static void main(String[] args) {
        int[][] matrix = { { -4, -5 } };

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] colSum = new int[m][n]; // colSum[i][j] = matrix[0][j]+matrix[1][j]+...+matrix[i][j]

        for (int col = 0; col < n; col++) {
            colSum[0][col] = matrix[0][col];
            for (int row = 1; row < m; row++) {
                colSum[row][col] = colSum[row - 1][col] + matrix[row][col];
            }
        }

        int c1 = 0, r1 = 0, c2 = 0, r2 = 0;
        int max = Integer.MIN_VALUE;

        for (int b = 0; b < m; b++) {// b开始的下标
            for (int e = b; e < m; e++) {// e结束的下标
                // 开始一维dp
                int curC = 0;
                int[] dp = new int[n];
                Arrays.fill(dp, Integer.MIN_VALUE);
                dp[0] = colSum[e][0];
                if (b != 0)
                    dp[0] -= colSum[b - 1][0];
                if (dp[0] > max) {
                    max = dp[0];
                    r1 = b;
                    r2 = e;
                    c1 = 0;
                    c2 = 0;
                }
                for (int col = 1; col < n; col++) {
                    int tmp = colSum[e][col];
                    if (b != 0)
                        tmp -= colSum[b - 1][col];
                    if (tmp < dp[col - 1] + tmp) {
                        dp[col] = dp[col - 1] + tmp;
                    } else {
                        dp[col] = tmp;
                        curC = col;
                    }
                    if (dp[col] > max) {
                        max = dp[col];
                        r1 = b;
                        r2 = e;
                        c1 = curC;
                        c2 = col;
                    }
                }
            }
        }

        System.out.println(max + " " + r1 + " " + c1 + " " + r2 + " " + c2);
    }
}
