package JAVA.Mid;

import java.util.Arrays;

public class mid_324 {

    public static void main(String[] args) {
        int[] nums = { 1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3 };

        int n = nums.length;
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);
        int gap = (n + 1) / 2;
        int start;
        int cur = 0;
        if (n % 2 == 0) {
            start = n - 1 - gap;
            while (start >= 0) {
                nums[cur++] = numsCopy[start];
                nums[cur++] = numsCopy[start + gap];
                start--;
            }
        } else {
            start = 0;
            while (start < gap - 1) {
                nums[cur++] = numsCopy[start];
                nums[cur++] = numsCopy[start + gap];
                start++;
            }
            nums[cur] = numsCopy[gap - 1];
        }
    }
}
