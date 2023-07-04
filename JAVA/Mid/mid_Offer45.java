package JAVA.Mid;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mid_Offer45 {

    public static void main(String[] args) {
        int[] nums = { 3, 30, 34, 5, 9 };

        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int len = Math.min(s1.length(), s2.length());
                for (int i = 0; i < len; i++) {
                    if (s1.charAt(i) != s2.charAt(i))
                        return s1.charAt(i) - s2.charAt(i);
                }
                if (s1.length() == s2.length())
                    return 0;
                if (s1.length() == len)
                    return compare(s1, s2.substring(len, s2.length()));
                else
                    return compare(s1.substring(len, s1.length()), s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i : nums) {
            pq.add(Integer.toString(i));
        }
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        System.out.println(sb);
    }
}
