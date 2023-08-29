package JAVA.Mid;

public class mid_8 {

    public static void main(String[] args) {
        String s = "";

        int cur = 0;
        while (cur < s.length() && s.charAt(cur) == ' ')
            cur++;
        boolean isPositive = true;
        boolean containsNum = false;
        if (cur < s.length() && s.charAt(cur) == '-') {
            isPositive = false;
            cur++;
        } else if (cur < s.length() && s.charAt(cur) == '+')
            cur++;
        long ans = 0;
        while (cur < s.length() && s.charAt(cur) >= '0' & s.charAt(cur) <= '9') {
            containsNum = true;
            ans *= 10;
            ans += s.charAt(cur) - '0';
            if ((isPositive & ans > Integer.MAX_VALUE) | (!isPositive & -ans < Integer.MIN_VALUE)) {
                int ret = isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                System.out.println(ret);
                return;
            }
            cur++;
        }
        if (!containsNum)
            return;
        int ret = isPositive ? (int) ans : (int) -ans;
        System.out.println(ret);
    }
}
