import java.util.Stack;

public class mid_739 {

    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };

        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                ans[j] = i - j;
            }
            stack.push(i);
        }
        for (int i : ans)
            System.out.print(i + " ");
    }
}
