package JAVA.Mid;

import java.util.Arrays;

public class mid_833 {

    public static void main(String[] args) {
        String s = "abcde";
        int[] indices = { 2, 2 };
        String[] sources = { "cdef", "bc" };
        String[] targets = { "f", "fe" };

        int[][] order = new int[indices.length][2];
        for (int i = 0; i < indices.length; i++) {
            order[i][0] = i;
            order[i][1] = indices[i];
        }
        Arrays.sort(order, (a, b) -> a[1] - b[1]);

        StringBuilder sb = new StringBuilder();
        int cur = 0, i = 0;
        while (cur < s.length()) {
            sb.append(s.substring(cur, order[i][1]));
            cur = order[i][1];
            String source = sources[order[i][0]];
            String target = targets[order[i][0]];
            if (cur + source.length() <= s.length() && s.substring(cur, cur + source.length()).equals(source)) {
                sb.append(target);
                cur += source.length();
            }
            i++;
            if (i >= order.length) {
                sb.append(s.substring(cur, s.length()));
                cur = s.length();
            }
        }
        System.out.println(sb.toString());
    }
}
