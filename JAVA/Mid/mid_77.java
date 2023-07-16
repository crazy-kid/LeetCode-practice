package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_77 {

    public static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        dfs(new ArrayList<Integer>(), n + 1, k);
        for (List<Integer> list : ans) {
            System.out.println();
            for (Integer i : list)
                System.out.print(i + " ");
        }
    }

    public static void dfs(List<Integer> list, int min, int left) {
        if (left == 0) {
            ans.add(List.copyOf(list));
            return;
        }
        for (int i = 1; i < min; i++) {
            list.add(i);
            dfs(list, i, left - 1);
            list.remove(list.size() - 1);
        }
    }
}
