import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class mid_2352 {

    public static void main(String[] args) {
        int[][] grid = { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } };

        HashMap<Integer, List<Integer>> rows = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, List<Integer>> cols = new HashMap<Integer, List<Integer>>();

        int n = grid.length;
        for (int row = 0; row < n; row++) {
            int sum = 0;
            for (int col = 0; col < n; col++)
                sum += grid[row][col];
            if (rows.containsKey(sum)) {
                rows.get(sum).add(row);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(row);
                rows.put(sum, l);
            }
        }
        for (int col = 0; col < n; col++) {
            int sum = 0;
            for (int row = 0; row < n; row++)
                sum += grid[row][col];
            if (cols.containsKey(sum)) {
                cols.get(sum).add(col);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(col);
                cols.put(sum, l);
            }
        }

        int ans = 0;
        for (int sum : rows.keySet())
            if (cols.containsKey(sum))
                for (int row : rows.get(sum))
                    for (int col : cols.get(sum))
                        if (isSame(grid, row, col))
                            ans++;

        System.out.println(ans);
    }

    public static boolean isSame(int[][] grid, int row, int col) {
        int n = grid.length;
        for (int p = 0; p < n; p++) {
            if (grid[row][p] != grid[p][col])
                return false;
        }
        return true;
    }
}
