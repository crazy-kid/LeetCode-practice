import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class mid_621 {

    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int n = 2;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {// o[0]:表示大写字母 o[1]:表示剩余task数量
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 65]++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                int[] tmp = { i, count[i] };
                pq.add(tmp);
            }
        }

        int[] pre = new int[26];// 上一个字母的安排的下标
        Arrays.fill(pre, -110);
        int cur = 0;
        while (!pq.isEmpty()) {
            List<int[]> list = new ArrayList<>();
            int[] l = pq.poll();
            list.add(l);
            while (cur - pre[l[0]] <= n & pq.size() > 0) {
                l = pq.poll();
                list.add(l);
            }
            if (cur - pre[l[0]] > n) {// 当前位置填入l[0]
                l[1]--;
                pre[l[0]] = cur;
            }
            for (int[] a : list) {// 拿出来的字母放回去
                if (a[1] > 0)
                    pq.add(a);
            }
            cur++;
        }

        System.out.println(cur);
    }
}
