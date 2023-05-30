public class mid_2090 {

    public static void main(String[] args) {
        int[] nums = { 7, 4, 3, 9, 1, 8, 5, 2, 6 };
        int k = 3;

        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++)
            ans[i] = -1;
        if (nums.length < 2 * k + 1)
            return;
        long sum = 0;
        for (int i = 0; i < 2 * k + 1; i++) {
            sum += nums[i];
        }
        for (int i = k; i < nums.length - k; i++) {
            ans[i] = (int) (sum / (2 * k + 1));
            if (i + k + 1 < nums.length) {
                sum += nums[i + k + 1];
                sum -= nums[i - k];
            }
        }
        for (int e : ans)
            System.out.print(e + " ");
    }
}
