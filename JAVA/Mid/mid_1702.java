package JAVA.Mid;

import java.util.HashMap;

public class mid_1702 {

    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 0 }, { 0, 0, 1 }, { 1, 1, 0 } };

        HashMap<String, Integer> count = new HashMap<String, Integer>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int row = 0; row < m; row++) {
            StringBuilder tmp = new StringBuilder();
            boolean isOne = matrix[row][0] == 1;
            for (int col = 0; col < n; col++) {
                if ((matrix[row][col] == 1 & isOne) | (matrix[row][col] == 0 & !isOne)) {
                    tmp.append('1');
                } else
                    tmp.append('0');
            }
            if (count.containsKey(tmp.toString())) {
                count.put(tmp.toString(), count.get(tmp.toString()) + 1);
            } else {
                count.put(tmp.toString(), 1);
            }
        }
        int max = 0;
        for (String key : count.keySet()) {
            max = Math.max(max, count.get(key));
        }
        System.out.println(max);
    }
}
