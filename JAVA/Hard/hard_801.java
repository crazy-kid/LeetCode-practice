package JAVA.Hard;

public class hard_801 {

    public static void main(String[] args) {
        int[] nums1 = { 0, 3, 5, 8, 9 };
        int[] nums2 = { 2, 1, 4, 6, 9 };

        int n = nums1.length;
        int[] dp = new int[n];
        int[] dps = new int[n];
        dps[0] = 1;

        for (int i = 1; i < n; i++) {
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            if (nums1[i - 1] < nums1[i] & nums2[i - 1] < nums2[i])
                a = dps[i - 1] + 1;
            if (nums1[i - 1] < nums2[i] & nums2[i - 1] < nums1[i])
                b = dp[i - 1] + 1;
            dps[i] = Math.min(a, b);
            a = Integer.MAX_VALUE;
            b = Integer.MAX_VALUE;
            if (nums1[i - 1] < nums1[i] & nums2[i - 1] < nums2[i])
                a = dp[i - 1];
            if (nums1[i - 1] < nums2[i] & nums2[i - 1] < nums1[i])
                b = dps[i - 1];
            dp[i] = Math.min(a, b);
        }
        System.out.println(Math.min(dp[n - 1], dps[n - 1]));
    }
}
