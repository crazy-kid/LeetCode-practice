public class mid_1310 {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 8 };
        int[][] queries = { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 3 } };

        int[] dp = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i + 1] = dp[i] ^ arr[i];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = dp[queries[i][1] + 1] ^ dp[queries[i][0]];
        }
        for (int i : ans)
            System.out.println(i);
    }
}