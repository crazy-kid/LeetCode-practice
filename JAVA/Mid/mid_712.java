package JAVA.Mid;

public class mid_712 {

    public static void main(String[] args) {
        String text1 = "delete";
        String text2 = "leet";

        char[] clist1 = text1.toCharArray();
        char[] clist2 = text2.toCharArray();
        int n1 = clist1.length;
        int n2 = clist2.length;

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i < n1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] + clist1[i - 1];
        }
        for (int i = 1; i < n2 + 1; i++) {
            dp[0][i] = dp[0][i - 1] + clist2[i - 1];
        }

        for (int i1 = 1; i1 < n1 + 1; i1++) {
            for (int i2 = 1; i2 < n2 + 1; i2++) {
                if (clist1[i1 - 1] == clist2[i2 - 1])
                    dp[i1][i2] = dp[i1 - 1][i2 - 1];
                else {
                    dp[i1][i2] = Math.min(dp[i1 - 1][i2] + clist1[i1 - 1], dp[i1][i2 - 1] + clist2[i2 - 1]);
                }
            }
        }
        System.out.println(dp[n1][n2]);

    }
}
