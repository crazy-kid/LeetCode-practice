package JAVA.Hard;

public class hard_329 {

    static int[][] matrix;
    static int[][] memo;
    static int m, n;
    static int[][] bais = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {
        matrix = new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        int ans = 0;
        for (int row = 0; row < m; row++)
            for (int col = 0; col < n; col++) {
                ans = Math.max(dfs(row, col), ans);
            }
        System.out.println(ans);
    }

    public static int dfs(int r, int c) {
        if (memo[r][c] > 0)
            return memo[r][c];
        int ret = 1;
        for (int[] b : bais) {
            if (r + b[0] >= 0 & r + b[0] < m & c + b[1] >= 0 & c + b[1] < n
                    && matrix[r + b[0]][c + b[1]] > matrix[r][c]) {
                ret = Math.max(ret, 1 + dfs(r + b[0], c + b[1]));
            }
        }
        memo[r][c] = ret;
        return ret;
    }
}
