package JAVA.Mid;

import java.util.ArrayList;

public class mid_22 {
    public static int n;

    public static void main(String[] args) {
        n = 3;
        ArrayList<String> list = new ArrayList<String>();
        list = gen(n, n);
        for (String s : list)
            System.out.println(s);
    }

    public static ArrayList<String> gen(int slots, int right) {
        ArrayList<String> list = new ArrayList<String>();
        if (slots == 1) {
            StringBuilder s = new StringBuilder("(");
            for (int i = 0; i < right; i++)
                s.append(')');
            list.add(s.toString());
            return list;
        }
        for (int i = 0; i <= right - slots + 1; i++) {
            StringBuilder s = new StringBuilder("(");
            for (int j = 0; j < i; j++)
                s.append(')');
            for (String str : gen(slots - 1, right - i)) {
                list.add(s.toString() + str);
            }
        }
        return list;
    }
}
