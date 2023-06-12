package JAVA.Mid;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class mid_1190 {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";

        char[] cList = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        Queue<Character> dq = new LinkedList<Character>();

        for (char c : cList) {
            stack.push(c);
            if (stack.peek() == ')') {
                stack.pop();
                char tmp = stack.pop();
                while (tmp != '(') {
                    dq.add(tmp);
                    tmp = stack.pop();
                }
                while (!dq.isEmpty())
                    stack.push(dq.poll());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}