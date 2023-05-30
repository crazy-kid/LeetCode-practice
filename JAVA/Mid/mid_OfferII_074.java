import java.util.ArrayList;

public class mid_OfferII_074 {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 4 }, { 3, 6 }, { 8, 10 }, { 15, 18 } };

        int[] block = new int[20002];
        for (int[] i : intervals) {
            block[2 * i[0]]++;
            block[2 * i[1] + 1]--;
        }
        int sum = 0;
        for (int i = 0; i < block.length; i++) {
            sum += block[i];
            block[i] = sum;
        }
        ArrayList<int[]> list = new ArrayList<>();
        int cur = 0;
        while (cur < block.length) {
            int[] tmp = new int[2];
            while (cur < block.length && block[cur] <= 0)
                cur++;
            tmp[0] = cur / 2;
            while (cur < block.length && block[cur] > 0)
                cur++;

            tmp[1] = (cur - 1) / 2;
            if (tmp[0] <= 10000)
                list.add(tmp);
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        for (int[] j : ans) {
            System.out.println(j[0] + " " + j[1]);
        }
    }
}
