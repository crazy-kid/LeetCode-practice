package JAVA.Mid;

public class mid_238 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };

        int n = nums.length;
        int[] preMul = new int[n + 1];
        preMul[0] = 1;
        int[] postMul = new int[n + 1];
        postMul[n] = 1;

        for (int i = 1; i < n + 1; i++) {
            preMul[i] = preMul[i - 1] * nums[i - 1];
            postMul[n - i] = postMul[n - i + 1] * nums[n - i];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = preMul[i] * postMul[i + 1];
        }
        for (int i : ans)
            System.out.println(i);
    }
}
