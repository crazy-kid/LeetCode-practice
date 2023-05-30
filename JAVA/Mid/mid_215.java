import java.util.PriorityQueue;

public class mid_215 {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k)
                pq.poll();
        }
        System.out.println(pq.poll());
    }
}
