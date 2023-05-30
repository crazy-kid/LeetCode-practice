import java.util.Arrays;

public class mid_1561 {

    public static void main(String[] args) {
        int[] piles = { 2, 4, 1, 2, 7, 8 };
        Arrays.sort(piles);
        int n = piles.length;
        n = n / 3;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += piles[piles.length - 2 - 2 * i];
        }
        System.out.println(ans);
    }
}
