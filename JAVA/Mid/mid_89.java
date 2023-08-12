package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_89 {

    public static void main(String[] args) {
        int n = 3;
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        for (int highBit = 0; highBit < n; highBit++) {
            int tmp = 1 << highBit;
            for (int i = (int) Math.pow(2, highBit) - 1; i >= 0; i--) {
                ans.add(tmp | ans.get(i));
            }
        }
        for (int num : ans) {
            System.out.println(Integer.toBinaryString(num));
        }
    }
}
