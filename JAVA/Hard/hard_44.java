package JAVA.Hard;

public class hard_44 {

    public static void main(String[] args) {
        String s = "acdcb";
        String p = "a*c?b";

        char[] sList = s.toCharArray();
        char[] pList = p.toCharArray();
        int ns = s.length();
        int np = p.length();
        boolean[][] dp = new boolean[ns + 1][np + 1];
        dp[0][0] = true;
        for (int i = 1; i < np + 1; i++) {
            if (dp[0][i - 1] & pList[i - 1] == '*')
                dp[0][i] = true;
            else {
                break;
            }
        }
        for (int i = 1; i < ns + 1; i++) {
            for (int j = 1; j < np + 1; j++) {
                dp[i][j] = dp[i][j] | ((sList[i - 1] == pList[j - 1]) & dp[i - 1][j - 1]);
                dp[i][j] = dp[i][j] | ('?' == pList[j - 1] & dp[i - 1][j - 1]);
                dp[i][j] = dp[i][j] | ('*' == pList[j - 1] & dp[i - 1][j]);
                dp[i][j] = dp[i][j] | ('*' == pList[j - 1] & dp[i][j - 1]);
            }
        }
        System.out.println(dp[ns][np]);
    }
}
