package JAVA.Mid;

public class mid_1208 {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;

        int left = 0, right = -1, max = 0, cur = 0;
        while (right + 1 < s.length()) {
            right++;
            cur += Math.abs(s.charAt(right) - t.charAt(right));
            while (cur > maxCost) {
                cur -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
