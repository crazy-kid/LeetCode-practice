package JAVA.Mid;

public class mid_97 {

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "a";

        char[] clist1 = s1.toCharArray();
        char[] clist2 = s2.toCharArray();
        char[] clist3 = s3.toCharArray();
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 + n2 != s3.length())
            return;
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i1 = 0; i1 < n1 + 1; i1++) {
            for (int i2 = 0; i2 < n2 + 1; i2++) {
                if (i1 - 1 >= 0)
                    dp[i1][i2] = dp[i1][i2] | (dp[i1 - 1][i2] & (clist1[i1 - 1] == clist3[i1 + i2 - 1]));
                if (i2 - 1 >= 0)
                    dp[i1][i2] = dp[i1][i2] | (dp[i1][i2 - 1] & (clist2[i2 - 1] == clist3[i1 + i2 - 1]));
            }
        }
        System.out.println(dp[n1][n2]);
    }
}
