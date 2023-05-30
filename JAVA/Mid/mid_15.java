import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class mid_15 {

    public static void main(String[] args) {
        int[] nums = { 0, 0, 0, 0 };

        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        HashSet<String> set = new HashSet<>();

        for (int i = 1; i < n - 1; i++) {
            int k = n - 1;
            for (int j = 0; j < i; j++) {
                while (k - 1 > i & nums[k] + nums[j] > -nums[i])
                    k--;
                if (nums[j] + nums[i] + nums[k] == 0) {
                    String s = Integer.toString(nums[j]) + " " + Integer.toString(nums[i]) + " "
                            + Integer.toString(nums[k]);
                    if (!set.contains(s)) {
                        set.add(s);
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[j]);
                        tmp.add(nums[i]);
                        tmp.add(nums[k]);
                        list.add(tmp);
                    }
                }
            }
        }
        for (List<Integer> l : list) {
            System.out.println(l.get(0) + " " + l.get(1) + " " + l.get(2) + " ");
        }
    }
}
