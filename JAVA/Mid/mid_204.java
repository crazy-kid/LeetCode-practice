package JAVA.Mid;

public class mid_204 {

    public static void main(String[] args) {
        int n = 10;

        boolean[] list = new boolean[n + 1];
        int ans = 0;
        int i = 2;
        while (i < n + 1) {
            if (!list[i]) {
                ans++;
                System.out.println(i);
                for (int j = i; j < n + 1; j = j + i) {
                    list[j] = true;
                }
            }
            while (i < n + 1 && list[i])
                i++;
        }
        System.out.println(ans);
    }
}
