package JAVA.Mid;

public class mid_311 {

    public static void main(String[] args) {
        String preOrder = "9,3,4,#,#,1,#,#,2,#,6,#,#";

        String[] list = preOrder.split(",");
        int n = list.length, k = 0;
        if (!list[n - 1].equals("#"))
            return;
        for (int i = 0; i < n - 1; i++) {
            if (list[i].equals("#"))
                k--;
            else
                k++;
            if (k < 0)
                return;
        }
        if (k != 0)
            return;
        System.out.println(true);
    }
}
