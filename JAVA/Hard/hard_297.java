package JAVA.Hard;

import java.util.Stack;

public class hard_297 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder ret = new StringBuilder();
        preOrder(root, ret);
        return ret.substring(1, ret.length());
    }

    public void preOrder(TreeNode root, StringBuilder tree) {
        if (root == null) {
            tree.append(",null");
            return;
        }
        tree.append("," + root.val);
        preOrder(root.left, tree);
        preOrder(root.right, tree);
    }

    public TreeNode deserialize(String data) {
        if (data.equals("null"))
            return null;
        String[] strList = data.split(",");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> count = new Stack<Integer>();
        TreeNode root = new TreeNode(Integer.valueOf(strList[0]));
        stack.push(root);
        count.push(0);
        for (int i = 1; i < strList.length; i++) {
            TreeNode child;
            if (strList[i].equals("null"))
                child = null;
            else
                child = new TreeNode(Integer.valueOf(strList[i]));

            TreeNode pa = stack.peek();
            switch (count.peek()) {
                case 0:
                    pa.left = child;
                    count.pop();
                    count.push(1);
                    break;
                case 1:
                    pa.right = child;
                    stack.pop();
                    count.pop();
                    break;
                default:
                    System.out.println("Exception in line 58");
            }
            if (child != null) {
                stack.push(child);
                count.push(0);
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
