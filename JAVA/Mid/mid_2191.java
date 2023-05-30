import java.util.Arrays;
import java.util.Comparator;

public class mid_2191 {

    public static void main(String[] args) {
        int[] mapping = { 5, 6, 8, 7, 4, 0, 3, 1, 9, 2 };
        Integer[] nums = { 99, 7686, 2212638, 97012948, 84234023 };

        Arrays.sort(nums, new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {
                int tmpa = Integer.valueOf(a);
                int tmpb = Integer.valueOf(b);

                int alpha = trans(tmpa, mapping);
                int beta = trans(tmpb, mapping);
                return alpha - beta;
            }
        });

        
    }

    public static int trans(int a, int[] mapping) {
        int ans = 0;
        int i = 0;
        if (a == 0)
            ans = mapping[0];
        while (a != 0) {
            ans += (mapping[a % 10] * Math.pow(10, i));
            a = a / 10;
            i++;
        }
        return ans;
    }
}