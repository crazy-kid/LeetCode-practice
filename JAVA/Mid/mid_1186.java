package JAVA.Mid;

public class mid_1186 {

    public static void main(String[] args) {
        int[] arr = { -1, -1, -1, -1 };

        int n = arr.length;
        int[] sum = new int[n + 1];
        int[] del = new int[n + 1];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            sum[i] = Math.max(sum[i - 1] + arr[i - 1], arr[i - 1]);
            ans = Math.max(ans, sum[i]);
            if (i > 1) {
                del[i] = Math.max(sum[i - 2] + arr[i - 1], del[i - 1] + arr[i - 1]);
                ans = Math.max(ans, del[i]);
            }
        }
        System.out.println(ans);
    }
}