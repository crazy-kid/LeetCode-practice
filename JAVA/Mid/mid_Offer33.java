package JAVA.Mid;

public class mid_Offer33 {

    public static void main(String[] args) {
        int[] postorder = { 1, 2, 5, 10, 6, 9, 4, 3 };
        System.out.println(check(postorder, 0, postorder.length - 1));
    }

    public static boolean check(int[] postorder, int l, int r) {
        System.out.println("l=" + l + " r=" + r);
        if (l >= r)
            return true;
        int root = postorder[r];
        int i;
        for (i = l - 1; i < r; i++) {
            if (postorder[i + 1] >= root)
                break;
        }
        if (!check(postorder, l, i))
            return false;
        for (int j = i + 1; j < r; j++)
            if (postorder[j] <= root)
                return false;
        if (!check(postorder, i + 1, r - 1))
            return false;
        return true;
    }
}
