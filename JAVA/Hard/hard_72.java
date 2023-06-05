package JAVA.Hard;

import java.util.Arrays;

public class hard_72 {

    public static void main(String[] args) {
        String text1 = "sea";
        String text2 = "eat";

        char[] clist1 = text1.toCharArray();
        char[] clist2 = text2.toCharArray();
        int n1 = clist1.length;
        int n2 = clist2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];

        if (n1 == 0 | n2 == 0)
            System.out.println(Math.max(n1, n2));
        for (int i = 0; i < n1 + 1; i++) {
            Arrays.fill(dp[i], Math.max(n1, n2));
            dp[i][0] = i;
        }
        for (int i = 0; i < n2 + 1; i++) {
            dp[0][i] = i;
        }

        if (clist1[0] != clist2[0])
            dp[1][1] = 1;
        else
            dp[1][1] = 0;
        for (int i2 = 1; i2 < n2 + 1; i2++) {
            for (int i1 = 1; i1 < n1 + 1; i1++) {
                if (clist1[i1 - 1] == clist2[i2 - 1])
                    dp[i1][i2] = Math.min(dp[i1][i2], dp[i1 - 1][i2 - 1]);// 最后一步:不动
                else
                    dp[i1][i2] = Math.min(dp[i1][i2], dp[i1 - 1][i2 - 1] + 1);// 最后一步:改
                dp[i1][i2] = Math.min(dp[i1][i2], dp[i1][i2 - 1] + 1);// 最后一步:插
                dp[i1][i2] = Math.min(dp[i1][i2], dp[i1 - 1][i2] + 1);// 最后一步:删
            }
        }
        System.out.println(dp[n1][n2]);
    }
}
