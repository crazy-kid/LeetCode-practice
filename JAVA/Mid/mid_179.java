package JAVA.Mid;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mid_179 {

    public static void main(String[] args) {
        int[] nums = { 0, 0 };

        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int i = 0;
                while (i < Math.min(s1.length(), s2.length())) {
                    if (s1.charAt(i) > s2.charAt(i))
                        return -1;
                    if (s1.charAt(i) < s2.charAt(i))
                        return 1;
                    i++;
                }
                if (s1.length() == s2.length())
                    return 0;
                if (i == s1.length())
                    return compare(s1, s2.substring(i, s2.length()));
                else
                    return compare(s1.substring(i, s1.length()), s2);
            }
        });

        for (int i : nums)
            pq.add(String.valueOf(i));
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            ans.append(pq.poll());
        }
        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0')
            i++;
        ans.delete(0, i);
        if (ans.length() == 0)
            return;
        System.out.println(ans.toString());
    }
}
