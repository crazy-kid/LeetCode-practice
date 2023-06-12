package JAVA.Mid;

public class mid_240 {
    public static int[][] matrix;
    public static int target;

    public static void main(String[] args) {
        matrix = new int[][] { { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        target = 20;

        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println(bsearch(0, 0, m - 1, n - 1));

    }

    public static boolean bsearch(int row1, int col1, int row2, int col2) {
        if (row1 > row2 | col1 > col2)
            return false;

        int r = (row1 + row2) / 2;
        int c = (col1 + col2) / 2;
        if (matrix[r][c] == target)
            return true;
        if (row1 == row2 & col1 == col2)
            return false;

        System.out.println(row1 + " " + col1 + " " + row2 + " " + col2);
        if (row2 - row1 <= 1 & col2 - col1 <= 1) {
            if (matrix[row1][col2] == target)
                return true;
            if (matrix[row2][col1] == target)
                return true;
            if (matrix[row2][col2] == target)
                return true;
            return false;
        }

        if (target > matrix[r][c]) {
            if (bsearch(r, c, row2, col2))
                return true;
        } else {
            if (bsearch(row1, col1, r, c))
                return true;
        }

        if (bsearch(row1, c + 1, r - 1, col2))
            return true;
        if (bsearch(r + 1, col1, row2, c - 1))
            return true;
        return false;
    }
}