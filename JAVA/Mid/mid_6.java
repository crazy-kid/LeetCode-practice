package JAVA.Mid;

public class mid_6 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        // PINALSIGYAHRPI
        if (numRows == 1)
            return;
        StringBuilder ans = new StringBuilder();
        int cur = 0;
        while (cur < s.length()) {
            ans.append(s.charAt(cur));
            cur += 2 * (numRows - 1);
        }
        for (int r = 2; r <= numRows - 1; r++) {
            cur = r - 1;
            while (cur < s.length()) {
                ans.append(s.charAt(cur));
                cur += 2 * (numRows - r);
                if (cur < s.length()) {
                    ans.append(s.charAt(cur));
                    cur += 2 * (r - 1);
                }
            }
        }
        cur = numRows - 1;
        while (cur < s.length()) {
            ans.append(s.charAt(cur));
            cur += 2 * (numRows - 1);
        }
        System.out.println(ans.toString());
    }
}
