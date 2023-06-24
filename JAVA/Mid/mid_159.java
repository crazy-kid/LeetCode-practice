package JAVA.Mid;

public class mid_159 {

    public static void main(String[] args) {
        String s = "ccaabbb";

        int left = 0, right = -1, max = 0, size = 0;
        int[] count = new int[58];
        while (++right < s.length()) {
            if (count[s.charAt(right) - 'A']++ == 0)
                size++;
            while (size > 2) {
                if (--count[s.charAt(left++) - 'A'] == 0)
                    size--;
            }
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
