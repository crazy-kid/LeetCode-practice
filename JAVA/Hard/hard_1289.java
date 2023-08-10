package JAVA.Hard;

public class hard_1289 {
    static int[][] grid = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 } };

    public static void main(String[] args) {

        int n = grid.length;
        if (n == 1)
            return;
        int[] min1 = { 0, Integer.MAX_VALUE }, min2 = { 0, Integer.MAX_VALUE };

        for (int col = 0; col < n; col++) {
            if (grid[0][col] < min1[1]) {
                min2 = min1.clone();
                min1 = new int[] { col, grid[0][col] };
            } else if (grid[0][col] < min2[1]) {
                min2 = new int[] { col, grid[0][col] };
            }
        }

        for (int row = 1; row < n; row++) {
            int[] curMin1 = { row, Integer.MAX_VALUE }, curMin2 = { row, Integer.MAX_VALUE };
            for (int col = 0; col < n; col++) {
                final int[] pre = col == min1[0] ? min2 : min1;
                if (grid[row][col] + pre[1] < curMin1[1]) {
                    curMin2 = curMin1.clone();
                    curMin1 = new int[] { col, grid[row][col] + pre[1] };
                } else if (grid[row][col] + pre[1] < curMin2[1]) {
                    curMin2 = new int[] { col, grid[row][col] + pre[1] };
                }
            }
            min1 = curMin1.clone();
            min2 = curMin2.clone();
        }
        System.out.println(min1[1]);
    }
}
