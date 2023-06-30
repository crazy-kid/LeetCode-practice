package JAVA.Mid;

public class mid_1292 {

    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 3, 2, 4, 3, 2 }, { 1, 1, 3, 2, 4, 3, 2 }, { 1, 1, 3, 2, 4, 3, 2 } };
        int threshold = 4;

        int m = mat.length, n = mat[0].length;
        int[][] pre = new int[m + 1][n + 1];
        for (int row = 1; row < m + 1; row++) {
            for (int col = 1; col < n + 1; col++) {
                pre[row][col] = pre[row - 1][col] + pre[row][col - 1] + mat[row - 1][col - 1] - pre[row - 1][col - 1];
            }
        }

        int left = 0, right = Math.min(n, m);
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(pre, mid, threshold))
                left = mid;
            else
                right = mid - 1;
        }
        System.out.println(left);
    }

    public static boolean check(int[][] pre, int len, int threshold) {
        if (len == 0)
            return true;
        int m = pre.length - 1, n = pre[0].length - 1;
        for (int row = len; row < m + 1; row++) {
            for (int col = len; col < n + 1; col++) {
                if (pre[row][col] - pre[row - len][col] - pre[row][col - len] + pre[row - len][col - len] <= threshold)
                    return true;
            }
        }
        return false;
    }
}
