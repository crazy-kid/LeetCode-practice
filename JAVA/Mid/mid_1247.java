package JAVA.Mid;

public class mid_1247 {

    public static void main(String[] args) {
        String s1 = "xx", s2 = "yy";
        int xy = 0, yx = 0, ans = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y')
                xy++;
            else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x')
                yx++;
        }
        ans += xy / 2;
        xy %= 2;
        ans += yx / 2;
        yx %= 2;
        if (xy + yx == 1)
            return;
        if (xy + yx == 2)
            ans += 2;
        System.out.println(ans);
    }
}
