package JAVA.Mid;

public class mid_1664 {

    public static void main(String[] args) {
        int[] nums = { 2, 1, 6, 4 };

        int n = nums.length;
        int[] preSum = new int[n];
        int[] postSum = new int[n];

        int odd = 0;
        int even = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even += nums[i];
                preSum[i] = even;
            } else {
                odd += nums[i];
                preSum[i] = odd;
            }
        }
        odd = 0;
        even = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                even += nums[i];
                postSum[i] = even;
            } else {
                odd += nums[i];
                postSum[i] = odd;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int n1 = 0;
            if (i - 2 >= 0)
                n1 = preSum[i - 2];
            int n2 = 0;
            if (i - 1 >= 0)
                n2 = preSum[i - 1];
            int n3 = 0;
            if (i + 1 < n)
                n3 = postSum[i + 1];
            int n4 = 0;
            if (i + 2 < n)
                n4 = postSum[i + 2];
            if (n1 + n3 == n2 + n4)
                ans++;
        }
        System.out.println(ans);
    }
}
