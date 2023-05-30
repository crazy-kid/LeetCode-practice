public class mid_91 {

    public static void main(String[] args) {
        String s = "2007";

        // 判断前导零
        if (s.charAt(0) == '0')
            return;
        char[] clist = s.toCharArray();
        int n = clist.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (clist[i - 1] != '0')
                dp[i] += dp[i - 1];
            if (clist[i - 1] - 48 + 10 * (clist[i - 2] - 48) <= 26 & clist[i - 2] != '0') {
                dp[i] += dp[i - 2];
            }
        }
        System.out.println(dp[n]);
    }
}
