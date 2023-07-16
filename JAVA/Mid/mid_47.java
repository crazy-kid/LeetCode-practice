package JAVA.Mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mid_47 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        dfs(list, nums, visit, ans);
        for (List<Integer> l : ans) {
            System.out.println();
            for (int i : l) {
                System.out.print(i + " ");
            }
        }
    }

    public static void dfs(List<Integer> list, int[] nums, boolean[] visit, List<List<Integer>> ans) {
        int n = visit.length;
        if (list.size() == n) {
            ans.add(List.copyOf(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                if (i > 0 && visit[i - 1] & nums[i - 1] == nums[i]) {
                    continue;
                }
                list.add(nums[i]);
                visit[i] = true;
                dfs(list, nums, visit, ans);
                list.remove(list.size() - 1);
                visit[i] = false;
            }
        }
    }
}
