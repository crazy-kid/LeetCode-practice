public class mid_50 {

    public static void main(String[] args) {
        double x = 2.0;
        int n = -2;

        double ans = pow(x, Math.abs(n));
        if (n < 0)
            System.out.println(1 / ans);
        else
            System.out.println(ans);

    }

    public static double pow(double x, int n) {
        if (n == 1)
            return x;
        if (n == 0)
            return 1;
        double ans = 1;
        if (n % 2 == 1) {
            ans *= x;
            n = n - 1;
        }
        double mul = pow(x, n / 2);
        ans *= mul * mul;
        return ans;
    }
}
