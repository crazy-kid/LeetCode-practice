package JAVA.Mid;

public class mid_255 {

    public static void main(String[] args) {
        int[] preorder = { 1, 2 };

        System.out.println(checkTree(preorder, 0, preorder.length - 1));

    }

    public static boolean checkTree(int[] preorder, int i, int j) {
        if (i >= j)
            return true;
        int root = preorder[i];
        int cur = i;
        while (cur < j && preorder[cur + 1] < root) {
            cur++;
        }
        if (!checkTree(preorder, i + 1, cur))
            return false;

        for (int k = cur + 1; k <= j; k++) {
            if (preorder[k] < root)
                return false;
        }
        if (!checkTree(preorder, cur + 1, j))
            return false;
        return true;
    }
}
