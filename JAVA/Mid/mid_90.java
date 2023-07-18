package JAVA.Mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mid_90 {

    public static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public static List<Integer> list = new ArrayList<Integer>();
    public static int[] nums;
    public static boolean[] choose;

    public static void main(String[] args) {
        nums = new int[] { 1, 2, 2 };

        Arrays.sort(nums);
        choose = new boolean[nums.length];
        dfs(list, 0);
        for (List<Integer> list : ans) {
            System.out.println();
            for (int i : list)
                System.out.print(i + " ");
        }
    }

    public static void dfs(List<Integer> list, int cur) {
        if (cur == nums.length) {
            ans.add(List.copyOf(list));
            return;
        }
        dfs(list, cur + 1);// 不选nums[cur]
        if (cur > 0 && !choose[cur - 1] && nums[cur - 1] == nums[cur])
            return;
        else {
            list.add(nums[cur]);// 选了nums[cur]
            choose[cur] = true;
            dfs(list, cur + 1);
            list.remove(list.size() - 1);
            choose[cur] = false;
        }
    }
}
