package JAVA.Mid;

public class mid_393 {

    public static void main(String[] args) {
        int[] data = { 145 };

        for (int i = 0; i < data.length; i++) {
            if ((data[i] >> 7) == 0)
                continue;
            int len = 0;
            for (int j = 7; j >= 3; j--) {
                if (((data[i] >> j) & 1) == 1)
                    len++;
                else
                    break;
            }
            if (len > 4 | len < 2)
                return;
            for (int j = 0; j < len - 1; j++) {
                i++;
                if (i >= data.length)
                    return;
                if (((data[i] >> 7) & 1) != 1 | (((data[i] >> 6) & 1) != 0)) {
                    return;
                }
            }
        }
        System.out.println(true);
    }
}
