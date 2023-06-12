package JAVA.Mid;

import java.util.Stack;

public class mid_OfferII_37 {

    public static void main(String[] args) {
        int[] asteroids = { -2, -1, 1, 2 };

        Stack<Integer> stack = new Stack<Integer>();

        for (int num : asteroids) {
            stack.push(num);
            checkStack(stack);
        }

        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--)
            ans[i] = stack.pop();
        for (int i : ans)
            System.out.println(i);
    }

    public static void checkStack(Stack<Integer> stack) {
        int num = 0;
        if (!stack.isEmpty())
            num = stack.pop();
        if (num < 0 && !stack.isEmpty() && stack.peek() > 0) {// 相撞了
            int left = stack.pop();
            if (left + num > 0) {
                stack.push(left);
                checkStack(stack);
            }
            if (left + num < 0) {
                stack.push(num);
                checkStack(stack);
            }
        } else {
            stack.push(num);
        }
    }
}
