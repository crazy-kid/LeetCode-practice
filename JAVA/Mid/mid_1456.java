package JAVA.Mid;

public class mid_1456 {

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i)))
                cur++;
            if (i - k >= 0 && isVowel(s.charAt(i - k)))
                cur--;
            ans = Math.max(ans, cur);
        }
        System.out.println(ans);
    }

    public static boolean isVowel(char c) {
        if (c == 'a' | c == 'e' | c == 'i' | c == 'o' | c == 'u')
            return true;
        return false;
    }
}
