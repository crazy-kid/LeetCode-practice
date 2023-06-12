package JAVA.Mid;

public class mid_55 {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 0, 5 };

        int n = nums.length;
        if (n == 1)
            return;
        int max = nums[0];
        int cur = 1;
        while (cur < n & cur <= max) {
            max = Math.max(max, cur + nums[cur]);
            cur++;
        }
        if (max == n - 1)
            System.out.println(true);
        else
            System.out.println(false);
    }
}
