package JAVA.Mid;

import java.util.HashMap;

class Node {

    char val;
    HashMap<Character, Node> children = new HashMap<Character, Node>();

    public Node() {
    }

    public Node(char c) {
        val = c;
    }
}

public class mid_820 {

    static String[] words = { "time", "me", "bell" };
    static int ans = 0;

    public static void main(String[] args) {
        Node root = new Node();
        for (String str : words) {
            Node pa = root;
            char[] list = str.toCharArray();
            for (int i = list.length - 1; i >= 0; i--) {
                char c = list[i];
                if (!pa.children.containsKey(c))
                    pa.children.put(c, new Node(c));
                pa = pa.children.get(c);
            }
        }
        depth(root, 0);
        System.out.println(ans);
    }

    public static void depth(Node root, int d) {
        if (root.children.size() == 0) {
            ans += d + 1;
            return;
        }
        for (char key : root.children.keySet()) {
            depth(root.children.get(key), d + 1);
        }
    }
}
