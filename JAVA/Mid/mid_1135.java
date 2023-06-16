package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_1135 {

    public static void main(String[] args) {
        int n = 3;
        int[][] relations = { { 1, 2 }, { 2, 3 }, { 3, 1 } };

        // 建图
        int[] count = new int[n];// 表示入度
        List<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int[] edge : relations) {
            int x = edge[0] - 1, y = edge[1] - 1;
            count[y]++;
            edges[x].add(y);
        }

        // 进行拓扑排序
        int ans = 0;
        while (true) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (count[i] == 0)
                    list.add(i);
            }
            if (list.size() == 0)
                break;
            for (int pa : list) {
                count[pa] = -1;
                for (int child : edges[pa])
                    count[child]--;
            }
            ans++;
        }
        for (int i : count)
            if (i != -1)
                return;
        System.out.print(ans);
    }
}
