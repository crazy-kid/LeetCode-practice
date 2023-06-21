package JAVA.Mid;

public class mid_567 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        int[] count = new int[26];
        for (char c : s1.toCharArray())
            count[c - 97]++;
        int left = 0, right = -1;
        int len = s1.length();
        while (right + 1 < s2.length()) {
            if (--count[s2.charAt(++right) - 97] < 0) {// 加入了不在s1中的字符
                while (count[s2.charAt(right) - 97] < 0) {
                    if (++count[s2.charAt(left++) - 97] > 0)
                        len++;
                }
            } else {
                len--;
            }
            if (len == 0) {
                System.out.println(true);
                return;
            }
        }
    }
}
