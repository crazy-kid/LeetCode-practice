import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class mid_46 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int n = nums.length;

    }

    public static void brackTrack(List<List<Integer>> list, int first, int[] nums) {
        if (first == nums.length)
            list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    public static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
