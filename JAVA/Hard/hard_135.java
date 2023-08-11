package JAVA.Hard;

public class hard_135 {

    public static void main(String[] args) {
        int[] ratings = { 1, 2, 87, 87, 87, 2, 1 };

        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
            else
                right[i] = 0;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(left[i], right[i]);
        }
        ans += n;
        System.out.println(ans);
    }
}
