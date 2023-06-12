package JAVA.Mid;

public class mid_498 {

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int row = 0;
        int col = 0;
        int cur = 0;
        boolean up = true;
        while (!(row == m - 1 & col == n - 1)) {
            ans[cur] = mat[row][col];
            cur++;
            if (up) {
                if (row - 1 >= 0 & col + 1 < n) {
                    row--;
                    col++;
                } else {
                    if (col + 1 < n)
                        col++;
                    else
                        row++;
                    up = false;
                }
            } else {
                if (row + 1 < m & col - 1 >= 0) {
                    row++;
                    col--;
                } else {
                    if (row + 1 < m)
                        row++;
                    else {
                        col++;
                    }
                    up = true;
                }
            }
        }
        ans[cur] = mat[m - 1][n - 1];
        for (int i : ans)
            System.out.print(i + " ");
    }
}
