import java.util.ArrayList;

public class mid_467 {

    public static void main(String[] args) {
        String s = "cac";

        char[] cList = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int l = 1;
        for (int i = 1; i < cList.length; i++) {
            if (cList[i] == cList[i - 1] + 1 || (cList[i] == 'a' & cList[i - 1] == 'z')) {
                l++;
            } else {
                list.add(l);
                l = 1;
            }
        }
        list.add(l);
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            int k = list.get(i);
            ans += k * (k - 1) / 2 + k;
        }
        System.out.println(ans);
    }
}
