package JAVA.Mid;

import java.util.Arrays;

public class mid_2517 {

    public static void main(String[] args) {
        // int[] price = { 13, 5, 1, 8, 21, 2 };
        // int k = 3;

        int[] price = { 7, 7, 7 };
        int k = 2;

        Arrays.sort(price);
        int n = price.length;
        int left = 0;
        int right = (price[n - 1] - price[0]) / (k - 1);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (possible(mid, price, k))
                left = mid;
            else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }

    public static boolean possible(int gap, int[] price, int k) {
        int count = 1;
        int cur = price[0];
        for (int i = 1; i < price.length; i++) {
            if (price[i] - cur >= gap) {
                cur = price[i];
                count++;
            }
            if (count >= k)
                return true;
        }
        if (count >= k)
            return true;
        return false;
    }
}
