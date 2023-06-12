package JAVA.Mid;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class mid_347 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;

        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int i : nums) {
            if (count.containsKey(i))
                count.put(i, count.get(i) + 1);
            else
                count.put(i, 1);
        }

        for (int key : count.keySet()) {
            int[] tmp = new int[2];
            tmp[0] = key;
            tmp[1] = count.get(key);
            pq.add(tmp);
        }

        int[] ans = new int[pq.size()];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }

        for (int i = 0; i < k; i++)
            System.out.println(ans[i]);
    }
}
