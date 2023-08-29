package JAVA.Mid;

public class mid_12 {

    public static void main(String[] args) {
        int num = 9;

        StringBuilder ans = new StringBuilder();
        int m = num / 1000;
        num -= m * 1000;
        for (int i = 0; i < m; i++)
            ans.append('M');

        if (num >= 900) {
            ans.append("CM");
            num -= 900;
        } else if (num >= 500) {
            ans.append('D');
            num -= 500;
        } else if (num >= 400 & num < 500) {
            ans.append("CD");
            num -= 400;
        }

        int c = num / 100;
        for (int i = 0; i < c; i++) {
            ans.append('C');
            num -= 100;
        }

        if (num >= 90) {
            ans.append("XC");
            num -= 90;
        } else if (num >= 50) {
            ans.append('L');
            num -= 50;
        } else if (num >= 40 & num < 50) {
            ans.append("XL");
            num -= 40;
        }

        int x = num / 10;
        for (int i = 0; i < x; i++) {
            ans.append('X');
            num -= 10;
        }
        if (num == 9) {
            ans.append("IX");
            num -= 9;
        } else if (num == 4) {
            ans.append("IV");
            num -= 4;
        } else if (num >= 5) {
            ans.append('V');
            num -= 5;
        }
        for (int i = 0; i < num; i++)
            ans.append('I');
        System.out.println(ans.toString());
    }
}
