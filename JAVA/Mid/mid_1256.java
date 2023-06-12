package JAVA.Mid;

public class mid_1256 {

    public static void main(String[] args) {

        int num = 107;
        StringBuilder s = new StringBuilder();
        while (num > 0) {
            if (num % 2 == 0) {
                num = (num - 2) / 2;
                s.append('1');
            } else {
                num = (num - 1) / 2;
                s.append('0');
            }
        }
        s.reverse();
        System.out.println(s.toString());
    }
}
