public class mid_2222 {

    public static void main(String[] args) {
        String s = "001101";

        char[] clist = s.toCharArray();
        int n = s.length();
        long ans = 0;
        int[] preSum = new int[n + 1];
        int[] postSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + clist[i - 1] - 48;
            postSum[n - i] = postSum[n - i + 1] + clist[n - i] - 48;
        }
        for (int i = 1; i < n - 1; i++) {
            if (clist[i] == '0') {
                ans += preSum[i] * postSum[i + 1];
            } else {
                ans += (i - preSum[i]) * (n - 1 - i - postSum[i + 1]);
            }
        }
        System.out.println(ans);
    }
}
