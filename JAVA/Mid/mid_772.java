package JAVA.Mid;

import java.util.ArrayList;
import java.util.List;

public class mid_772 {

    public static void main(String[] args) {
        String[] source = {
                "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;",
                "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}" };

        boolean inComment = false;
        List<String> ans = new ArrayList<String>();
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < source.length; i++) {
            int begin = 0;
            for (int j = 0; j < source[i].length(); j++) {
                if (inComment) {
                    if (source[i].charAt(j) == '*' & j + 1 < source[i].length() && source[i].charAt(j + 1) == '/') {
                        inComment = false;
                        j++;
                        begin = j + 1;
                    }
                    continue;
                }
                if (source[i].charAt(j) == '/' & j + 1 < source[i].length()) {
                    if (source[i].charAt(j + 1) == '/') {
                        line.append(source[i].subSequence(begin, j));
                        j++;
                        break;
                    }
                    if (source[i].charAt(j + 1) == '*') {
                        line.append(source[i].subSequence(begin, j));
                        j++;
                        inComment = true;
                    }
                }
                if (j == source[i].length() - 1)
                    line.append(source[i].subSequence(begin, j + 1));
            }
            if (line.length() > 0 & !inComment) {
                ans.add(line.toString());
                line = new StringBuilder();
            }
        }

        for (String str : ans) {
            System.out.println(str);
        }
    }
}
