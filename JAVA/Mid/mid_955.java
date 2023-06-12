package JAVA.Mid;

public class mid_955 {

    public static void main(String[] args) {
        String[] strs = { "zyx", "wvu", "tsr" };

        boolean[] Ranked = new boolean[strs.length];
        int l = strs[0].length();

        char[][] chars = new char[strs.length][strs[0].length()];
        for (int i = 0; i < strs.length; i++) {
            chars[i] = strs[i].toCharArray();
        }

        int ans = 0;
        for (int col = 0; col < l; col++) {
            boolean needDelete = false;

            for (int row = 0; row < strs.length - 1; row++) {
                if (chars[row][col] > chars[row + 1][col] && !Ranked[row]) {
                    needDelete = true;
                    break;
                }
            }

            if (needDelete) {
                ans++;
                continue;
            }

            for (int row = 0; row < strs.length - 1; row++) {
                if (chars[row][col] < chars[row + 1][col]) {
                    Ranked[row] = true;
                }
            }
        }
        System.out.println(ans);
    }
}
