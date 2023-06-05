package JAVA.Hard;

public class hard_10 {

    public static void main(String[] args) {
        String s = "aaa";
        String p = "ab*ac*a";

        char[] sList = s.toCharArray();
        char[] pList = p.toCharArray();
        int ns = s.length();
        int np = p.length();
        boolean[][] dp = new boolean[ns + 1][np + 1];
        dp[0][0] = true;
        for (int i = 1; i < np + 1; i++) {
            if (dp[0][i - 1] & pList[i - 1] == '*')
                dp[0][i] = true;
            if (i - 2 >= 0 && dp[0][i - 2] & pList[i - 1] == '*')
                dp[0][i] = true;
        }

        for (int i = 1; i < ns + 1; i++) {
            for (int j = 1; j < np + 1; j++) {
                dp[i][j] = dp[i][j] || ((sList[i - 1] == pList[j - 1]) & dp[i - 1][j - 1]);
                dp[i][j] = dp[i][j] || ('.' == pList[j - 1] & dp[i - 1][j - 1]);
                if (j - 2 >= 0) {
                    dp[i][j] = dp[i][j] || ('*' == pList[j - 1] & dp[i][j - 2]);// *把前一个匹配符置零了
                    dp[i][j] = dp[i][j] || ('.' == pList[j - 2] & '*' == pList[j - 1] & dp[i - 1][j]);// *与.结合可表示任何一个字符
                    dp[i][j] = dp[i][j] || (pList[j - 2] == sList[i - 1] & '*' == pList[j - 1] & dp[i - 1][j]);// *与字母结合表示该字母
                }
                if (i - 2 >= 0)
                    dp[i][j] = dp[i][j] || ('*' == pList[j - 1] & dp[i][j - 1]);// *表示空
            }
        }
        System.out.println(dp[ns][np]);
    }
}
