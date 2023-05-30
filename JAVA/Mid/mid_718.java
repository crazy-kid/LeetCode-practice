public class mid_718 {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 2, 1 };
        int[] nums2 = { 3, 2, 1, 4, 7 };

        int max = Integer.MIN_VALUE;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i1 = 1; i1 < nums1.length + 1; i1++) {
            for (int i2 = 1; i2 < nums2.length + 1; i2++) {
                if (nums1[i1 - 1] == nums2[i2 - 1]) {
                    dp[i1][i2] = Math.max(dp[i1][i2], dp[i1 - 1][i2 - 1] + 1);
                    max = Math.max(max, dp[i1][i2]);
                }

            }
        }
        System.out.println(max);
    }
}