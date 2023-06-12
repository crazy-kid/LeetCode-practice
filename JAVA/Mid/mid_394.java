package JAVA.Mid;

public class mid_394 {

    public static void main(String[] args) {
        String s = "3[a2[c]]";

        System.out.println(decode(s));
    }

    public static String decode(String s) {
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= 48 & s.charAt(i) <= 57) {// 当前字符是数字
                int count = 0;
                while (s.charAt(i) >= 48 & s.charAt(i) <= 57) {
                    count = count * 10 + (s.charAt(i) - 48);
                    i++;
                } // 循环结束后i指向'['
                i++;
                int begin = i;// 子字符串开始的下标
                int left = 1;// '['数
                int right = 0;// ']'数
                while (left > right) {
                    switch (s.charAt(i)) {
                        case '[':
                            left++;
                            break;
                        case ']':
                            right++;
                            break;
                        default:
                            break;
                    }
                    i++;
                } // 循环结束后i指向']'的后一位
                String tmp = decode(s.substring(begin, i - 1));
                for (int j = 0; j < count; j++) {
                    ret.append(tmp);
                }
            } else {// 当前字符不是数字
                ret.append(s.charAt(i));
                i++;
            }
        }
        return ret.toString();
    }
}
