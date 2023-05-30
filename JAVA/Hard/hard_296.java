import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class hard_296 {

    public static void main(String[] args) {
        int[][] grid = { { 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };

        List<Integer> rowIndex = new ArrayList<Integer>();
        List<Integer> colIndex = new ArrayList<Integer>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rowIndex.add(row);
                    colIndex.add(col);
                }
            }
        }
        colIndex.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                return i - j;
            }
        });

        int rowMid, colMid;
        int n = rowIndex.size();
        if (n % 2 == 0) {
            rowMid = (rowIndex.get(n / 2) + rowIndex.get(n / 2 - 1)) / 2;
            colMid = (colIndex.get(n / 2) + colIndex.get(n / 2 - 1)) / 2;
        } else {
            rowMid = rowIndex.get(n / 2);
            colMid = colIndex.get(n / 2);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(rowIndex.get(i) - rowMid) + Math.abs(colIndex.get(i) - colMid);
        }
        System.out.println(ans);
    }
}
