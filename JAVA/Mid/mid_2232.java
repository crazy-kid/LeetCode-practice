public class mid_2232 {
    public static void main(String[] args) {
        String s = "247+38";

        String[] strList = s.split("\\+");

        int num1;
        int numa;
        int num2;
        int numb;
        int min = Integer.MAX_VALUE;
        String s1 = "", sa = "", s2 = "", sb = "";
        for (int i = 0; i < strList[0].length(); i++) {
            if (i == 0) {
                num1 = 1;
                numa = Integer.valueOf(strList[0].substring(0, strList[0].length()));
            } else {
                num1 = Integer.valueOf(strList[0].substring(0, i));
                numa = Integer.valueOf(strList[0].substring(i, strList[0].length()));
            }
            for (int j = 0; j < strList[1].length(); j++) {
                if (j == strList[1].length() - 1) {
                    num2 = 1;
                    numb = Integer.valueOf(strList[1].substring(0, strList[1].length()));
                } else {
                    numb = Integer.valueOf(strList[1].substring(0, j + 1));
                    num2 = Integer.valueOf(strList[1].substring(j + 1, strList[1].length()));
                }
                if (min > num1 * (numa + numb) * num2) {
                    s1 = Integer.toString(num1);
                    sa = Integer.toString(numa);
                    s2 = Integer.toString(num2);
                    sb = Integer.toString(numb);
                    min = num1 * (numa + numb) * num2;
                }
            }
        }
        StringBuilder ans = new StringBuilder("");
        if (s1.length() + sa.length() == strList[0].length())
            ans.append(s1);
        ans.append("(");
        ans.append(sa);
        ans.append("+");
        ans.append(sb + ")");
        if (s2.length() + sb.length() == strList[1].length())
            ans.append(s2);
        System.out.println(ans.toString());
    }

}
