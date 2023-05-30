import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class mid_17 {
    public static HashMap<Character, char[]> map;

    public static void main(String[] args) {
        String digits = "";

        char[] clist = digits.toCharArray();
        map = new HashMap<Character, char[]>();
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 's', 't' });
        map.put('8', new char[] { 't', 'u', 'v' });
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });

        List<String> list = new ArrayList<String>();
        list.add("");
        for (char c : clist) {
            list = nextS(list, c);
        }
        for (String s : list)
            System.out.println(s);
    }

    public static ArrayList<String> nextS(List<String> list, char key) {
        ArrayList<String> ans = new ArrayList<String>();
        for (String s : list) {
            for (char c : map.get(key)) {
                ans.add(s + c);
            }
        }
        return ans;
    }
}