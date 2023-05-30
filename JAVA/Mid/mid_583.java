import java.util.Arrays;

public class mid_583 {

    public static void main(String[] args) {
        String word1 = "troph";//t ph
        String word2 = "etylph";

        char[] clist1 = word1.toCharArray();
        char[] clist2 = word2.toCharArray();

        int n1 = clist1.length;
        int n2 = clist2.length;
        int[] dp = new int[n1];
        int[] sub = new int[n1];
        Arrays.fill(sub, -1);

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (clist2[j] == clist1[i]) {
                    dp[i] = 1;
                    sub[i] = j;
                    break;
                }
            }
        }

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < i; j++) {
                int k = 0;
                for (k = sub[j] + 1; k < n2; k++) {
                    if (clist2[k] == clist1[i])
                        break;
                }
                if (k < n2 & dp[i] < dp[j] + 1) {// 在clist2中找到了对应字符,且比现在的更长
                    dp[i] = dp[j] + 1;
                    sub[i] = k;
                }
            }
        }

        int ans = 0;
        for (int e : dp) {
            ans = Math.max(ans, e);
        }
        System.out.println(n1 + n2 - 2 * ans);
    }
}
