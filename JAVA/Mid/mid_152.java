import java.util.Arrays;

public class mid_152 {

    public static void main(String[] args) {
        int[] nums = { 7, -2, -4 };

        int n = nums.length;
        int[] dpp = new int[n + 1];
        int[] dpn = new int[n + 1];

        Arrays.fill(dpp, -1);
        Arrays.fill(dpn, 1);
        if (nums[0] >= 0) {
            dpp[1] = nums[0];
        } else {
            dpn[1] = nums[0];
        }

        for (int i = 2; i <= n; i++) {
            if (nums[i - 1] == 0) {
                dpp[i] = 0;
                dpn[i] = 0;
                continue;
            }
            if (nums[i - 1] >= 0) {
                dpp[i] = Math.max(nums[i - 1] * dpp[i - 1], nums[i - 1]);
                if (dpn[i - 1] <= 0)
                    dpn[i] = nums[i - 1] * dpn[i - 1];
            } else {// nums[i-1]<0
                if (dpn[i - 1] <= 0)
                    dpp[i] = nums[i - 1] * dpn[i - 1];
                dpn[i] = Math.min(nums[i - 1] * dpp[i - 1], nums[i - 1]);
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i : dpp)
            if (i >= 0)
                ans = Math.max(ans, i);
        for (int i : dpn)
            if (i <= 0)
                ans = Math.max(ans, i);
        System.out.println(ans);
    }
}
