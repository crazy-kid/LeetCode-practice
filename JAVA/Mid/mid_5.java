package JAVA.Mid;

import java.util.Arrays;

public class mid_5 {

    public static void main(String[] args) {
        String s = "aacabdkacaa";

        char[] clist = s.toCharArray();
        int n = clist.length;

        boolean[][] dp = new boolean[n + 1][n];// row 回文字串长度 col 下标
        Arrays.fill(dp[0], true);
        Arrays.fill(dp[1], true);
        int max = 1;
        int index = 0;
        for (int l = 2; l < n + 1; l++) {
            for (int i = l - 1; i < n; i++) {
                if (clist[i - l + 1] == clist[i] & dp[l - 2][i - 1]) {
                    dp[l][i] = true;
                    if (l > max) {
                        max = l;
                        index = i;
                    }
                }
            }
        }
        System.out.println(index + " " + max);

    }
}