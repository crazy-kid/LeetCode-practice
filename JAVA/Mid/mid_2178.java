package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_2178 {

    public static void main(String[] args) {
        long finalSum = 28;

        List<Long> ans = new ArrayList<Long>();
        if (finalSum % 2 != 0)
            return;
        long sum = 0, base = 2;
        while (sum + base <= finalSum) {
            sum += base;
            ans.add(base);
            base += 2;
        }
        ans.set(ans.size() - 1, base - 2 + finalSum - sum);
        for (Long l : ans)
            System.out.print(l + " ");
    }
}
