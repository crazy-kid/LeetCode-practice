package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_417 {

    public static int[][] heights = {
            { 1, 2, 2, 3, 5 },
            { 3, 2, 3, 4, 4 },
            { 2, 4, 5, 3, 1 },
            { 6, 7, 1, 4, 5 },
            { 5, 1, 1, 2, 4 } };

    public static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public static int m, n;
    public static int[][] flowable;

    public static void main(String[] args) {
        m = heights.length;
        n = heights[0].length;
        flowable = new int[m][n];// 1=太平洋 2=大西洋
        for (int row = 0; row < m; row++) {
            dfs(row, 0, 1);
            dfs(row, n - 1, 2);
        }
        for (int col = 0; col < n; col++) {
            dfs(0, col, 1);
            dfs(m - 1, col, 2);
        }
        for (int row = 0; row < m; row++)
            for (int col = 0; col < n; col++) {
                if ((flowable[row][col] & 3) == 3) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(row);
                    list.add(col);
                    ans.add(list);
                }
            }
    }

    public static void dfs(int row, int col, int val) {
        if ((flowable[row][col] & val) > 0)
            return;
        flowable[row][col] |= val;
        if (row > 0 && heights[row - 1][col] >= heights[row][col])
            dfs(row - 1, col, val);
        if (row < m - 1 && heights[row + 1][col] >= heights[row][col])
            dfs(row + 1, col, val);
        if (col > 0 && heights[row][col - 1] >= heights[row][col])
            dfs(row, col - 1, val);
        if (col < n - 1 && heights[row][col + 1] >= heights[row][col])
            dfs(row, col + 1, val);
    }
}
