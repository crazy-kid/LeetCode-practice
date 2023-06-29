package JAVA.Easy;

public class easy_844 {

    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";

        int curs = s.length() - 1;
        int curt = t.length() - 1;

        while (curs >= 0 | curt >= 0) {
            curs = update(s, curs, 0);
            curt = update(t, curt, 0);
            if (curs >= 0 & curt >= 0 && s.charAt(curs) == t.charAt(curt)) {
                curs--;
                curt--;
            } else {
                System.out.println(-1);
                return;
            }
        }
    }

    public static int update(String str, int cur, int skip) {
        if (cur < 0)
            return -1;
        if (str.charAt(cur) != '#') {
            if (skip <= 0)
                return cur;
            else
                return update(str, cur - 1, skip - 1);
        } else
            return update(str, cur - 1, skip + 1);
    }
}
