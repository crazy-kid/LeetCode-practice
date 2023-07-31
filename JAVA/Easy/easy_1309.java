package JAVA.Easy;

public class easy_1309 {

    public static void main(String[] args) {
        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";

        String[] list = s.split("#");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < list.length - 1; i++) {
            String str = list[i];
            if (str.length() >= 2) {
                for (int j = 0; j < str.length() - 2; j++)
                    ans.append((char) (str.charAt(j) - '1' + 'a'));
                ans.append((char) (Integer.valueOf(str.substring(str.length() - 2, str.length())) - 1 + 'a'));
            } else {
                ans.append((char) (Integer.valueOf(str.charAt(0)) - 1 + 'a'));
            }
        }
        String last = list[list.length - 1];
        if (s.charAt(s.length() - 1) == '#') {
            for (int j = 0; j < last.length() - 2; j++)
                ans.append((char) (last.charAt(j) - '1' + 'a'));
            ans.append((char) (Integer.valueOf(last.substring(last.length() - 2, last.length())) - 1 + 'a'));
        } else
            for (int j = 0; j < last.length(); j++) {
                ans.append((char) (last.charAt(j) - '1' + 'a'));
            }
        System.out.println(ans.toString());
    }
}
