package JAVA.Mid;

public class mid_921 {

    public static void main(String[] args) {
        String s = "())";
        int left = 0, right = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                left++;
            else
                right++;
            if (right > left) {
                ans++;
                left++;
            }
        }
        ans += left - right;
        System.out.println(ans);
    }
}
