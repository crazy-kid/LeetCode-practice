package JAVA.Hard;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class hard_1028 {

    public static void main(String[] args) {
        String traversal = "1-2--3---4-5--6---7";

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        int cur = 0, num = 0, depth;
        while (cur < traversal.length() && traversal.charAt(cur) != '-') {// 获取val
            num = num * 10 + (traversal.charAt(cur) - '0');
            cur++;
        }
        TreeNode root = new TreeNode(num);
        stack.add(root);
        depthStack.add(0);
        while (cur < traversal.length()) {
            num = 0;
            depth = 0;
            while (traversal.charAt(cur) == '-') {// 获取深度
                depth++;
                cur++;
            }
            while (cur < traversal.length() && traversal.charAt(cur) != '-') {// 获取val
                num = num * 10 + (traversal.charAt(cur) - '0');
                cur++;
            }
            TreeNode child = new TreeNode(num);
            while (!stack.isEmpty() && depthStack.peek() >= depth) {
                stack.pop();
                depthStack.pop();
            }
            if (!stack.isEmpty()) {// 有父亲节点
                TreeNode pa = stack.peek();
                if (pa.left == null)
                    pa.left = child;
                else {// 接在右子树上
                    stack.pop();
                    depthStack.pop();
                    pa.right = child;
                }
            }
            stack.add(child);
            depthStack.add(depth);
        }
    }
}
