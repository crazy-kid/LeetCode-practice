package JAVA.Mid;

public class mid_526 {
    static int ans = 0;
    static boolean[] used;
    static int n;

    public static void main(String[] args) {
        n = 1;
        used = new boolean[n + 1];
        dfs(1);
        System.out.println(ans);
    }

    public static void dfs(int index) {
        if (index == n + 1) {
            ans++;
            return;
        }
        for (int num = 1; num <= n; num++) {
            if (!used[num] && (num % index == 0 || index % num == 0)) {
                used[num] = true;
                dfs(index + 1);
                used[num] = false;
            }
        }
    }
}
