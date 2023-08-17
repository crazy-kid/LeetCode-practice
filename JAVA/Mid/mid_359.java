package JAVA.Mid;

import java.util.Arrays;

public class mid_359 {

    public static void main(String[] args) {
        int n = 3131;

        int[][] next = { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, {}, { 0, 1, 7 }, { 2, 6 }, { 1, 3 },
                { 2, 4 } };
        long ans = 0;
        final int MOD = (int) 1e9 + 7;
        if (n == 1)
            return;
        long[] pre = new long[10];
        long[] cur = new long[10];
        Arrays.fill(pre, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int dst : next[j]) {
                    cur[dst] += pre[j];
                    cur[dst] %= MOD;
                }
            }
            pre = cur;
            cur = new long[10];
        }
        for (long i : pre) {
            ans += i;
            ans %= MOD;
        }
        System.out.println(ans);
    }
}
