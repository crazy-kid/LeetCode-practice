package JAVA.Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class hard_428 {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder ans = new StringBuilder();
        Queue<Node> queue = new LinkedList<Node>();
        if (root == null)
            return ans.toString();
        queue.add(root);
        ans.append(root.val + ",null,");
        while (!queue.isEmpty()) {
            Node pa = queue.poll();
            for (Node child : pa.children) {
                ans.append(child.val + ",");
                queue.add(child);
            }
            ans.append("null,");
        }
        // System.out.print(ans.toString());
        return ans.subSequence(0, ans.length() - 1).toString();

    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.equals(""))
            return null;
        String[] strList = data.split(",");
        Node root = new Node(Integer.valueOf(strList[0]), new ArrayList<Node>());
        Queue<Node> queue = new LinkedList<Node>();
        // ArrayList<Node> preList = new ArrayList<Node>();//上一层节点列表
        queue.add(root);
        int size = queue.size();// 当前层node个数
        int index = 2;// strList 中的下标
        while (!queue.isEmpty()) {// 构造queue中node的child，每一次循环构造一层
            size = queue.size();
            int count = 0;
            while (count < size) {// 每一次循环给当前层的父节点添加子结点
                Node pa = queue.poll();
                while (!strList[index].equals("null")) {
                    List<Node> tmp = new ArrayList<Node>();
                    Node c = new Node(Integer.valueOf(strList[index]), tmp);
                    pa.children.add(c);
                    queue.add(c);
                    index++;
                }
                count++;
                index++;// 跳过null
            }
        }
        return root;
    }

}
