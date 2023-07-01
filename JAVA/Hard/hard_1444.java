package JAVA.Hard;

public class hard_1444 {
    public static int[][][] dp;
    public static int[][] preSum;
    public static int m, n;
    public static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        String[] pizza = { "A..", "A..", "..." };
        int k = 1;

        m = pizza.length;
        n = pizza[0].length();
        // 构建二维前缀和
        preSum = new int[m + 1][n + 1];
        for (int row = 1; row < m + 1; row++) {
            for (int col = 1; col < n + 1; col++) {
                preSum[row][col] = preSum[row - 1][col] + preSum[row][col - 1] - preSum[row - 1][col - 1];
                if (pizza[row - 1].charAt(col - 1) == 'A')
                    preSum[row][col]++;
            }
        }

        dp = new int[k][m][n];// [剩下的刀数][行号][列号] 初始化条件
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (sum(row, col, m - 1, n - 1) > 0)
                    dp[0][row][col] = 1;
                else
                    dp[0][row][col] = -1;
            }
        }
        System.out.println(cal(k - 1, 0, 0));
    }

    public static int cal(int left, int r, int c) {
        if (dp[left][r][c] != 0)
            return dp[left][r][c];
        // dp[left][r][c]尚未被计算
        if (sum(r, c, m - 1, n - 1) < left + 1)
            return dp[left][r][c] = -1;
        int ret = 0;
        for (int row = r; row <= m - 2; row++) {
            int cut = sum(r, c, row, n - 1);
            if (cut > 0) {
                ret += Math.max(cal(left - 1, row + 1, c), 0);
                ret %= MOD;
            }
        }
        for (int col = c; col <= n - 2; col++) {
            int cut = sum(r, c, m - 1, col);
            if (cut > 0) {
                ret += Math.max(cal(left - 1, r, col + 1), 0);
                ret %= MOD;
            }
        }
        return dp[left][r][c] = ret;
    }

    // 计算矩形区域苹果数
    public static int sum(int r1, int c1, int r2, int c2) {
        return preSum[r2 + 1][c2 + 1] - preSum[r2 + 1][c1] - preSum[r1][c2 + 1] + preSum[r1][c1];
    }
}
