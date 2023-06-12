package JAVA.Mid;

public class mid_918 {

    public static void main(String[] args) {
        int[] nums = { -3, -2, -3 };

        boolean allNegtive = true;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i >= 0) {
                allNegtive = false;
                break;
            }
            max = Math.max(max, i);
        }
        if (allNegtive)
            return;

        int sum = 0;
        int n = nums.length;
        int[] dpp = new int[n];
        int[] dpn = new int[n];

        dpp[0] = nums[0];
        dpn[0] = nums[0];
        sum += nums[0];
        for (int i = 1; i < n; i++) {
            dpp[i] = Math.max(nums[i], dpp[i - 1] + nums[i]);
            dpn[i] = Math.min(nums[i], dpn[i - 1] + nums[i]);
            sum += nums[i];
        }
        int M = Integer.MIN_VALUE;
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            M = Math.max(dpp[i], M);
            m = Math.min(dpn[i], m);
        }
        int ans = Math.max(M, sum - m);
        System.out.println(ans);
    }
}
