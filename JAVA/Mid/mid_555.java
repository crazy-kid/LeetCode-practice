package JAVA.Mid;

import java.util.Arrays;

public class mid_555 {

    public static int[] tree = new int[16];
    public static int count = 0;

    public static void main(String[] args) {
        int[] nums = { 113, 215, 221 };

        Arrays.fill(tree, -1);
        for (int i : nums) {
            int val = i % 10;
            i /= 10;
            int b = i % 10;
            i /= 10;
            int a = i % 10;
            tree[(int) (Math.pow(2.0, a - 1)) + b - 1] = val;
        }
        dfs(tree, 1, 0);
        System.out.println(count);
    }

    public static void dfs(int[] tree, int root, int sum) {
        if (root > 7 || (tree[2 * root] < 0 & tree[2 * root + 1] < 0)) {
            count += sum + tree[root];
            return;
        }
        sum += tree[root];
        if (tree[2 * root] >= 0)
            dfs(tree, 2 * root, sum);
        if (tree[2 * root + 1] >= 0)
            dfs(tree, 2 * root + 1, sum);
    }
}
