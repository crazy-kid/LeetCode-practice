package JAVA.Mid;

public class mid_443 {

    public static void main(String[] args) {
        char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };

        int curN = 1, len = 0, slow = 0, fast = 1;
        for (slow = 0, fast = 1; fast <= chars.length; fast++) {
            if (fast < chars.length && chars[fast] == chars[fast - 1])
                curN++;
            else {
                chars[slow++] = chars[fast - 1];
                if (curN > 1) {
                    String str = String.valueOf(curN);
                    len += str.length();
                    for (int i = 0; i < str.length(); i++)
                        chars[slow++] = str.charAt(i);
                }
                len++;
                curN = 1;
            }
        }
        for (int i = 0; i < len; i++)
            System.out.print(chars[i] + " ");

    }
}
