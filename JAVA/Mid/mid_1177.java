package JAVA.Mid;

public class mid_1177 {

    public static void main(String[] args) {
        String str = "abcda";
        int[][] queries = { { 3, 3, 0 }, { 1, 2, 0 }, { 0, 3, 1 }, { 0, 3, 2 }, { 0, 4, 1 } };

        int n = str.length();
        char[] clist = str.toCharArray();
        int[][] precount = new int[26][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                precount[j][i + 1] = precount[j][i];
            }
            precount[clist[i] - 97][i + 1]++;
        }

        boolean[] ans = new boolean[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int[] query = queries[j];
            int oddcount = 0;
            for (int i = 0; i < 26; i++) {
                if ((precount[i][query[1] + 1] - precount[i][query[0]]) % 2 == 1) {
                    oddcount++;
                }
            }
            if (oddcount <= 2 * query[2] & (query[1] - query[0]) % 2 == 1)
                ans[j] = true;
            if (oddcount - 1 <= 2 * query[2] & (query[1] - query[0]) % 2 == 0)
                ans[j] = true;
        }
        for (boolean e : ans)
            System.out.print(e + " ");
    }
}
