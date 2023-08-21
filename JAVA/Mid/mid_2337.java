package JAVA.Mid;

public class mid_2337 {

    public static void main(String[] args) {
        // String start = "_L__R__R_";
        String start = "_R";
        String target = "R_";

        if (start.length() != target.length())
            return;
        int n = start.length();
        char[] slist = start.toCharArray();
        char[] tlist = target.toCharArray();

        int curS = 0, curT = 0, left = -1;
        while (curS < n | curT < n) {
            while (curS < n && slist[curS] == '_')
                curS++;
            while (curT < n && tlist[curT] == '_')
                curT++;
            if (curS >= n & curT >= n)
                break;
            if (curS >= n | curT >= n || slist[curS] != tlist[curT])
                return;
            else if (slist[curS] == 'R') {
                left = curS;
            } else if (curT <= left | curS < curT)// slist[curs] =='L'
                return;
            curS++;
            curT++;
        }

        curS = n - 1;
        curT = n - 1;
        int right = n;
        while (curS >= 0 | curT >= 0) {
            while (curS >= 0 && slist[curS] == '_')
                curS--;
            while (curT >= 0 && tlist[curT] == '_')
                curT--;
            if (curS < 0 & curT < 0)
                break;
            if (curS < 0 | curT < 0 || slist[curS] != tlist[curT])
                return;
            else if (slist[curS] == 'L') {
                right = curS;
            } else if (curT >= right | curS > curT)// slist[curs] =='R'
                return;
            curS--;
            curT--;
        }
        System.out.println(true);
    }
}
