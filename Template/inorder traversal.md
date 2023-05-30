```java
    List<Integer> list = new ArrayList<Integer>();//中序遍历的结果
    Stack<TreeNode> stack = new Stack<TreeNode>();//辅助栈
    TreeNode p = root;//表示子树的根,且尚未入栈
    while (p != null | !stack.isEmpty()) {
        if (p == null) {//该子树遍历到头了
            p = stack.pop();//访问该子树的根
            list.add(p.val);
            p = p.right;//准备遍历右子树
            continue;
        }
        stack.push(p);
        p = p.left;
    }
```