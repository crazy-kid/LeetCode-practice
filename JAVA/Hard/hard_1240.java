package JAVA.Hard;

public class hard_1240 {

    static int ans, n, m;

    public static void main(String[] args) {
        n = 5;
        m = 8;

        ans = Math.max(n, m);
        boolean[][] mat = new boolean[n][m];
        dfs(0, 0, mat, 0);
        System.out.println(ans);

    }

    public static void dfs(int r, int c, boolean[][] mat, int count) {
        if (count >= ans)
            return;
        if (r >= n) {
            ans = Math.min(ans, count);
            return;
        }
        if (c >= m) {
            dfs(r + 1, 0, mat, count);
            return;
        }
        if (mat[r][c]) {
            dfs(r, c + 1, mat, count);
            return;
        }
        for (int len = Math.min(n - r, m - c); len > 0; len--) {
            if (check(r, c, mat, len)) {
                fillUp(r, c, mat, len, true);
                dfs(r, c + len, mat, count + 1);
                fillUp(r, c, mat, len, false);
            }
        }

    }

    public static boolean check(int r, int c, boolean[][] mat, int len) {
        // if (r + len - 1 >= n | c + len - 1 >= m)
        // return false;
        for (int row = r; row <= r + len - 1; row++) {
            for (int col = c; col <= c + len - 1; col++) {
                if (mat[row][col])
                    return false;
            }
        }
        return true;
    }

    public static boolean fillUp(int r, int c, boolean[][] mat, int len, boolean val) {
        // if (r + len - 1 >= n | c + len - 1 >= m)
        // return false;
        for (int row = r; row <= r + len - 1; row++) {
            for (int col = c; col <= c + len - 1; col++) {
                mat[row][col] = val;
            }
        }
        return true;
    }
}