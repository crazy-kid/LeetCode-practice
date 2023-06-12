package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_54 {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

        List<Integer> ans = new ArrayList<Integer>();
        int t = 0;
        int b = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        while (true) {
            for (int i = l; i <= r; i++) {
                ans.add(matrix[t][i]);
            }
            t++;
            if (t > b)
                break;
            for (int i = t; i <= b; i++) {
                ans.add(matrix[i][r]);
            }
            r--;
            if (r < l)
                break;
            for (int i = r; i >= l; i--) {
                ans.add(matrix[b][i]);
            }
            b--;
            if (t > b)
                break;
            for (int i = b; i >= t; i--) {
                ans.add(matrix[i][l]);
            }
            l++;
            if (r < l)
                break;
        }
    }
}
