import java.util.Arrays;

public class mid_01_08 {

    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };

        boolean row0 = false;
        boolean col0 = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i : matrix[0])
            if (i == 0)
                row0 = true;
        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0)
                col0 = true;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        for (int row = 1; row < m; row++)
            if (matrix[row][0] == 0)
                for (int col = 1; col < n; col++)
                    matrix[row][col] = 0;
        for (int col = 1; col < n; col++)
            if (matrix[0][col] == 0)
                for (int row = 1; row < m; row++)
                    matrix[row][col] = 0;
        if (row0)
            Arrays.fill(matrix[0], 0);
        if (col0)
            for (int row = 0; row < m; row++)
                matrix[row][0] = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
