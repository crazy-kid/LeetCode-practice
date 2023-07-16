package JAVA.Mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mid_39 {

    public static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;

        Arrays.sort(candidates);
        dfs(new ArrayList<Integer>(), candidates, target);
        for (List<Integer> list : ans) {
            System.out.println();
            for (Integer i : list)
                System.out.print(i + " ");
        }
    }

    public static void dfs(List<Integer> list, int[] candidates, int target) {
        if (target == 0) {
            ans.add(List.copyOf(list));
            return;
        }
        if (target < 0)
            return;

        int last = list.isEmpty() ? Integer.MAX_VALUE : list.get(list.size() - 1);
        for (int i : candidates) {
            if (i > last)
                return;
            list.add(i);
            dfs(list, candidates, target - i);
            list.remove(list.size() - 1);
        }
    }
}
