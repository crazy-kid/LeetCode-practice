package JAVA.Hard;

public class hard_902 {

    public static void main(String[] args) {
        String[] digits = { "1", "3", "5", "7" };
        int n = 100;

        int[] nums = new int[digits.length];
        for (int i = 0; i < digits.length; i++)
            nums[i] = Integer.valueOf(digits[i]);

        int[] max = new int[Integer.toString(n).length()];
        for (int i = 0; i < max.length; i++) {
            max[i] = n % 10;
            n /= 10;
        }
        int ans = 0;
        for (int i = 1; i <= max.length - 1; i++)
            ans += (int) Math.pow(nums.length, i);
        int[] dp = new int[max.length];
        for (int num : nums) {
            if (num > max[0])
                break;
            dp[0]++;
        }

        for (int i = 1; i < max.length; i++) {
            for (int num : nums) {
                if (num < max[i])
                    dp[i] += (int) Math.pow(nums.length, i);
                else if (num == max[i])
                    dp[i] += dp[i - 1];
                else
                    break;
            }
        }
        ans += dp[max.length - 1];
        System.out.println(ans);
    }
}
