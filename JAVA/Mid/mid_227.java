package JAVA.Mid;

import java.util.Stack;

public class mid_227 {

    public static void main(String[] args) {
        String s = "1-1+1";

        char[] slist = s.toCharArray();

        int cur = 0;
        Stack<String> stack = new Stack<String>();
        while (cur < slist.length) {
            switch (slist[cur]) {
                case ' ':
                    cur++;
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    stack.push(String.valueOf(slist[cur]));
                    cur++;
                    break;
                default:
                    int num = 0;
                    while (cur < slist.length && slist[cur] >= '0' & slist[cur] <= '9') {
                        num *= 10;
                        num += slist[cur] - '0';
                        cur++;
                    }
                    if (!stack.isEmpty() && stack.peek().equals("*") | stack.peek().equals("/")) {
                        if (stack.pop().equals("*"))
                            stack.push(String.valueOf(Integer.valueOf(stack.pop()) * num));
                        else
                            stack.push(String.valueOf(Integer.valueOf(stack.pop()) / num));
                    } else
                        stack.push(String.valueOf(num));
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            int num = Integer.valueOf(stack.pop());
            if (!stack.isEmpty()) {
                String op = stack.pop();
                if (op.equals("+"))
                    ans += num;
                else
                    ans -= num;
            } else
                ans += num;
        }
        System.out.println(ans);
    }

}
