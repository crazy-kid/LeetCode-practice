
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class test {
    public static int t = 1702766719;

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        List<Integer> list = new ArrayList<>();
        list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i : list)
            System.out.println(i);
    }
}