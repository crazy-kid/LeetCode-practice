package JAVA.Mid;

public class mid_1094 {

    public static void main(String[] args) {
        int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
        int capacity = 4;

        int[] nums = new int[2002];
        for (int[] t : trips) {
            nums[2 * t[1] + 1] += t[0];
            nums[2 * t[2]] -= t[0];
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            if (nums[i] > capacity)
                return;
        }
    }
}
