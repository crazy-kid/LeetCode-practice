import java.util.Comparator;
import java.util.PriorityQueue;

public class mid_2611 {

    public static void main(String[] args) {
        int[] reward1 = { 1, 1, 3, 4 };
        int[] reward2 = { 4, 4, 1, 1 };
        int k = 2;

        int n = reward1.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < n; i++) {
            int[] tmp = { reward1[i] - reward2[i], i };
            pq.add(tmp);
            if (pq.size() > k)
                pq.poll();
        }
        int sum = 0;
        for (int i : reward2)
            sum += i;
        while (!pq.isEmpty()) {
            sum += pq.poll()[0];
        }

        System.out.println(sum);
    }
}
