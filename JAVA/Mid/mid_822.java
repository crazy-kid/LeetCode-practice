package JAVA.Mid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class mid_822 {
    public static void main(String[] args) {
        int[] fronts = { 1, 2, 4, 4, 7 };
        int[] backs = { 1, 3, 4, 1, 3 };

        final int MAX = 2000;
        boolean[] valid = new boolean[MAX + 1];
        Arrays.fill(valid, true);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                int ni = MAX + 1, nj = MAX + 1;
                ni = valid[fronts[i]] ? Math.min(fronts[i], ni) : ni;
                ni = valid[backs[i]] ? Math.min(backs[i], ni) : ni;
                nj = valid[fronts[j]] ? Math.min(fronts[j], nj) : nj;
                nj = valid[backs[j]] ? Math.min(backs[j], nj) : nj;
                return ni - nj;
            }
        });
        for (int i = 0; i < fronts.length; i++)
            if (fronts[i] == backs[i])
                valid[fronts[i]] = false;

        for (int i = 0; i < fronts.length; i++)
            if (valid[fronts[i]] | valid[backs[i]])
                pq.add(i);
        int index;
        if (!pq.isEmpty())
            index = pq.poll();
        else
            return;
        int ret = MAX + 1;
        if (valid[fronts[index]])
            ret = Math.min(fronts[index], ret);
        if (valid[backs[index]])
            ret = Math.min(backs[index], ret);
        System.out.println(ret);
    }
}