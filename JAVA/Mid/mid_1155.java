package JAVA.Mid;

public class mid_1155 {

    static int n = 30;
    static int k = 20;
    static int target = 193;
    static final int MOD = (int) 1e9 + 7;
    static long[][] memo = new long[n + 1][target + 1];

    public static void main(String[] args) {
        long ans = cal(n, target);
        System.out.println(ans);
    }

    public static long cal(int rolls, int t) {
        if (t <= 0 || t > rolls * k || t < rolls)
            return 0;
        System.out.println(rolls + " " + t);
        if (memo[rolls][t] > 0)
            return memo[rolls][t];
        long ret = 0;
        if (rolls == 1)
            ret++;
        else
            for (int i = k; i >= 1; i--) {
                ret += cal(rolls - 1, t - i);
                ret %= MOD;
            }
        memo[rolls][t] = ret;
        return ret;
    }
}
