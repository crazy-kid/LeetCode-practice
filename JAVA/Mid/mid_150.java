import java.util.Stack;

public class mid_150 {

    public static void main(String[] args) {
        String[] tokens = { "4", "13", "5", "/", "+" };

        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1 + n2);
                continue;
            }
            if (str.equals("-")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 - n1);
                continue;
            }
            if (str.equals("*")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1 * n2);
                continue;
            }
            if (str.equals("/")) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 / n1);
                continue;
            }
            stack.push(Integer.valueOf(str));
        }
        System.out.println(stack.peek());
    }
}
