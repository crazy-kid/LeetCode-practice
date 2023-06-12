package JAVA.Mid;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mid_OfferI_40 {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 1 };
        int k = 2;

        if (k == 0)
            return;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i : arr) {
            if (pq.size() < k) {
                pq.add(i);
                continue;
            }
            if (i < pq.peek()) {
                pq.poll();
                pq.add(i);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++)
            ans[i] = pq.poll();

    }
}
