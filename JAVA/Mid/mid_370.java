package JAVA.Mid;

public class mid_370 {

    public static void main(String[] args) {
        int length = 5;
        int[][] updates = { { 1, 3, 2 }, { 2, 4, 3 }, { 0, 2, -2 } };

        int[] diff = new int[length];
        for (int[] list : updates) {
            diff[list[0]] += list[2];
            if (list[1] + 1 < length)
                diff[list[1] + 1] -= list[2];
        }
        for (int i = 1; i < length; i++) {
            diff[i] += diff[i - 1];
        }
        for (int i : diff) {
            System.out.println(i);
        }
    }
}
