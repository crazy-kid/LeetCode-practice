package JAVA.Mid;

public class mid_28 {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        int i = 0;// 主串下标 这是非降的
        int j = 0;// 字串下标
        int[] next = buildNext(needle);

        while (i < haystack.length()) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                if (j == needle.length() - 1) {
                    System.out.println(i - j);
                    return;
                }
                i++;
                j++;
            } else {
                if (j == 0)
                    i++;
                else {
                    j = next[j - 1];
                }
            }
        }

    }

    public static int[] buildNext(String s) {
        int[] next = new int[s.length()];
        int i = 1;
        int prelen = 0;
        while (i < next.length) {
            if (s.charAt(prelen) == s.charAt(i)) {
                prelen++;
                next[i] = prelen;
                i++;
            } else if (prelen == 0) {
                next[i] = 0;
                i++;
            } else
                prelen = next[prelen - 1];
        }
        return next;
    }
}
