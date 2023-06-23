package JAVA.Mid;

import java.util.Arrays;

public class mid_1151 {

    public static void main(String[] args) {
        int[] data = { 1, 0, 1, 0, 1 };

        int min = data.length;
        int sum = Arrays.stream(data).sum();
        int right = -1, cur = 0;
        while (right + 1 < data.length) {
            right++;
            cur += data[right];
            if (right - sum + 1 >= 0) {
                if (right - sum >= 0)
                    cur -= data[right - sum];
                min = Math.min(min, sum - cur);
            }
        }
        System.out.println(min);
    }
}
