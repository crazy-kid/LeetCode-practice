package JAVA.Easy;

public class easy_338 {

    public static void main(String[] args) {
        int n = 5;

        int[] ans = new int[n + 1];
        int pow = 1;
        for (int i = 1; i < n + 1; i++) {
            if (i == pow) {
                ans[i] = 1;
                pow = pow * 2;
            } else {
                ans[i] = ans[i - pow / 2] + 1;
            }
        }

        for (int e : ans)
            System.out.println(e);
    }
}
