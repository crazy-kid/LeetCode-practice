package JAVA.Mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mid_40 {

    public static int[] candidates;
    public static List<List<Integer>> ans;
    public static boolean[] choose;

    public static void main(String[] args) {
        candidates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;

        ans = new ArrayList<List<Integer>>();
        choose = new boolean[candidates.length];
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        dfs(list, 0, target);
        for (List<Integer> l : ans) {
            System.out.println();
            for (int i : l)
                System.out.print(i + " ");
        }

    }

    public static void dfs(List<Integer> list, int cur, int target) {
        if (target == 0) {
            ans.add(List.copyOf(list));
            return;
        }
        for (; cur < candidates.length && candidates[cur] <= target; cur++) {
            if (cur > 0 && candidates[cur - 1] == candidates[cur] && !choose[cur - 1])
                continue;
            choose[cur] = true;
            list.add(candidates[cur]);
            dfs(list, cur + 1, target - candidates[cur]);
            choose[cur] = false;
            list.remove(list.size() - 1);
        }
    }
}
