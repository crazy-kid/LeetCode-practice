package JAVA.Mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mid_16_19 {

    static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

    public static void main(String[] args) {
        int[][] land = {
                { 0, 2, 1, 0 },
                { 0, 1, 0, 1 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 1 }
        };

        List<Integer> list = new ArrayList<>();
        for (int row = 0; row < land.length; row++) {
            for (int col = 0; col < land[0].length; col++) {
                if (land[row][col] == 0)
                    list.add(dfs(land, row, col));
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        Arrays.sort(ans);

        for (int i : ans)
            System.out.print(i + " ");
    }

    public static int dfs(int[][] land, int x, int y) {
        int ret = 1;
        land[x][y] = -1;
        for (int[] dir : dirs) {
            if (x + dir[0] >= 0 & x + dir[0] < land.length & y + dir[1] >= 0 & y + dir[1] < land[0].length
                    && land[x + dir[0]][y + dir[1]] == 0) {
                ret += dfs(land, x + dir[0], y + dir[1]);
            }
        }
        return ret;
    }
}
