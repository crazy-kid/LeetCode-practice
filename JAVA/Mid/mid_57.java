package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_57 {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };

        if (intervals.length == 0)
            return;
        List<int[]> ans = new ArrayList<int[]>();
        int cur = 0;
        boolean add = false;
        while (cur < intervals.length | !add) {
            int[] next;
            if (cur >= intervals.length || !add & newInterval[0] <= intervals[cur][0]) {
                next = newInterval;
                add = true;
                cur--;
            } else
                next = intervals[cur];

            if (ans.size() == 0) {
                ans.add(next);
            } else {
                int[] last = ans.get(ans.size() - 1);
                if (next[0] > last[1]) {
                    ans.add(next);
                } else {
                    last[1] = Math.max(last[1], next[1]);
                }
            }
            cur++;
        }

        for (int[] interval : ans) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
