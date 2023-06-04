package JAVA.Test;

import java.util.Arrays;

public class test {

    public static void main(String[] args) {
        String[] slist = { "abc", "aaa", "cba" };
        Arrays.sort(slist);
        for (String s : slist)
            System.out.println(s);
        StringBuilder s = new StringBuilder();
    }
}
