package JAVA.Hard;

import java.util.Stack;

public class hard_32 {
    public static void main(String[] args) {
        String s = ")()())()()(";

        char[] cList = s.toCharArray();

        Stack<Integer> stack = new Stack<Integer>();// -1==')',-2=='('
        for (char c : cList) {
            if (c == ')' & !stack.isEmpty()) {
                int count = 0;
                boolean find = false;
                if (!stack.isEmpty() && stack.peek() > 0) {// 把合法字串弹出
                    count += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == -2) {// 找到了对应的'('
                    find = true;
                    stack.pop();
                    count += 1;
                }
                if (!stack.isEmpty() && stack.peek() > 0) {// 合并合法数目
                    count += stack.pop();
                }
                if (count > 0)
                    stack.push(count);
                if (!find)
                    stack.push(-1);
            } else {
                if (c == '(')
                    stack.push(-2);
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans = Math.max(ans, stack.pop());
        }
        System.out.println(2 * ans);
    }
}