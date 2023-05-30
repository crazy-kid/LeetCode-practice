import java.util.HashMap;

public class easy_266 {

    public static void main(String[] args) {
        String s = "carerac";

        char[] clist = s.toCharArray();
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : clist) {
            if (count.containsKey(c))
                count.put(c, count.get(c) + 1);
            else
                count.put(c, 1);
        }
        int odd = 0;
        for (char key : count.keySet()) {
            if (count.get(key) % 2 == 1)
                odd++;
        }
        if (odd > 1)
            System.out.println("false");
    }
}