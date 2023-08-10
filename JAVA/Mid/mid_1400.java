package JAVA.Mid;

public class mid_1400 {

    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;
        if (s.length() < k)
            return;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int odd = 0;
        for (int i : count) {
            if (i % 2 == 1)
                odd++;
        }
        System.out.println(odd <= k);
    }
}
