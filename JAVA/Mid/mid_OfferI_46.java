package JAVA.Mid;

public class mid_OfferI_46 {
    public static void main(String[] args) {
        int num = 25;

        char[] charList = Integer.toString(num).toCharArray();
        int[] dp = new int[charList.length + 1];
        // System.out.println('1'-48);
        dp[dp.length - 2] = 1;
        dp[dp.length - 1] = 1;
        for (int i = dp.length - 3; i >= 0; i--) {
            if (charList[i] != '0' & (charList[i] - 48) * 10 + charList[i + 1] - 48 <= 25) {
                dp[i] = dp[i] + dp[i + 2];
            }
            dp[i] = dp[i] + dp[i + 1];
            System.out.println(dp[i]);
        }
    }
}
