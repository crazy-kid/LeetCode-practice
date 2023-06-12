package JAVA.Mid;

public class mid_38 {

    public static void main(String[] args) {
        int n = 5;

        StringBuilder s = new StringBuilder("1");
        StringBuilder t = new StringBuilder();
        for (int i = 1; i < n; i++) {
            char c = s.charAt(0);
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == c)
                    count++;
                else {
                    t.append(String.valueOf(Integer.toString(count)));
                    t.append(c);
                    count = 1;
                    c = s.charAt(j);
                }
            }
            t.append(String.valueOf(Integer.toString(count)));
            t.append(c);
            s = t;
            t = new StringBuilder("");
        }
        System.out.println(s.toString());
    }
}
