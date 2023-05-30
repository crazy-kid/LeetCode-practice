import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class c implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[0] - o2[0] == 0)
            return o1[1] - o2[1];
        return o1[0] - o2[0];
    }
}

public class hard_354 {

    public static void main(String[] args) {
        int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };

        ArrayList<int[]> list = new ArrayList<int[]>();
        for (int[] e : envelopes) {
            list.add(e);
        }
        Comparator<int[]> com = new c();
        list.sort(com);

        int n = list.size();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                int[] o1 = list.get(i - 1);
                int[] o2 = list.get(j - 1);
                if (o1[0] > o2[0] & o1[1] > o2[1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int ans = 0;
        for (int e : dp) {
            ans = Math.max(ans, e);
        }
        System.out.println(ans);
    }
}
