package JAVA.Mid;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class mid_433 {

    static String startGene = "AACCGGTT";
    static String endGene = "AAACGGTA";
    static String[] bank = { "AACCGGTA", "AACCGCTA", "AAACGGTA" };
    static String[] list = { "A", "T", "C", "G" };

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        for (String str : bank)
            set.add(str);
        if (!set.contains(endGene))
            return;

        int ans = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.add(startGene);
        set.remove(startGene);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                StringBuilder sb = new StringBuilder(s);
                for (int j = 0; j < sb.length(); j++) {
                    char pre = sb.charAt(j);
                    for (String c : list) {
                        sb.replace(j, j + 1, c);
                        if (set.contains(sb.toString())) {
                            if (sb.toString().equals(endGene)) {
                                System.out.println(ans);
                                return;
                            }
                            queue.add(sb.toString());
                            set.remove(sb.toString());
                        }
                    }
                    sb.replace(j, j + 1, String.valueOf(pre));
                }
            }
            ans++;
        }
    }
}
