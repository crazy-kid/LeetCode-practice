package JAVA.Mid;

public class mid_1909 {

    public static void main(String[] args) {
        int[][] bookings = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
        int n = 5;

        int[] ans = new int[n];
        for (int[] e : bookings) {
            ans[e[0] - 1] += e[2];
            if (e[1] < n)
                ans[e[1]] -= e[2];
        }
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }
    }
}
