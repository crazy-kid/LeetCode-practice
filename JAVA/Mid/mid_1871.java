package JAVA.Mid;

public class mid_1871 {

    public static void main(String[] args) {
        String s = "01101110";
        int minJump = 2, maxJump = 3;

        int n = s.length();
        int[] pre = new int[n + 1];
        pre[1] = 1;

        for (int i = 1; i < n; i++) {
            int left = Math.max(i - maxJump, 0);
            pre[i + 1] = pre[i];
            if (s.charAt(i) == '0' & i - minJump >= 0 && pre[i - minJump + 1] - pre[left] > 0) {
                pre[i + 1]++;
            }
        }
        System.out.println(pre[n] - pre[n - 1] == 1 ? true : false);
    }
}
