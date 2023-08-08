package JAVA.Mid;

public class mid_1749 {

    public static void main(String[] args) {
        int[] nums = { 2, -5, 1, -4, 3, -2 };
        int n = nums.length, ans = Integer.MIN_VALUE;
        int[] dpp = new int[2], dpn = new int[2];
        for (int i = 0; i < n; i++) {
            dpp[1] = Math.max(nums[i], nums[i] + dpp[0]);
            dpn[1] = Math.max(-nums[i], -nums[i] + dpn[0]);
            ans = Math.max(ans, Math.max(dpp[1], dpn[1]));
            dpp[0] = dpp[1];
            dpn[0] = dpn[1];
        }
        System.out.println(ans);
    }
}
