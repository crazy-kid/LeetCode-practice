package JAVA.Mid;

public class mid_1375 {

    public static void main(String[] args) {
        int[] flips = { 4, 1, 2, 3 };

        int n = flips.length;
        boolean[] state = new boolean[n];
        int cur = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            state[flips[i] - 1] = true;
            while (cur + 1 < n && state[cur + 1]) {
                cur++;
            }
            if (cur + 1 >= i + 1)
                ans++;
        }
        System.out.println(ans);
    }
}
