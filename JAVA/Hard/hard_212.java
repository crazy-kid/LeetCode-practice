package JAVA.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class hard_212 {

    static class Node {
        char val = '0';
        boolean isEnd = false;
        HashMap<Character, Node> children = new HashMap<Character, Node>();

        Node(char val, boolean isEnd) {
            this.val = val;
            this.isEnd = isEnd;
        }
    }

    static char[][] board = {
            { 'o', 'a', 'b', 'n' },
            { 'o', 't', 'a', 'e' },
            { 'a', 'h', 'k', 'r' },
            { 'a', 'f', 'l', 'v' } };
    // static char[][] board = { { 'a', 'a' } };
    static boolean[][] visited;
    static int m, n;
    static List<String> ans;

    public static void main(String[] args) {
        String[] words = { "oa", "oaa" };

        ans = new ArrayList<String>();

        // 建立前缀树
        Node root = new Node('0', false);
        for (String word : words) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (!cur.children.containsKey(word.charAt(i)))
                    cur.children.put(word.charAt(i), new Node(word.charAt(i), false));
                cur = cur.children.get(word.charAt(i));
                if (i == word.length() - 1)
                    cur.isEnd = true;
            }
        }

        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                Node cur = root.children.getOrDefault(board[row][col], null);
                if (cur == null)
                    continue;
                StringBuilder path = new StringBuilder(String.valueOf(board[row][col]));
                visited[row][col] = true;
                dfs(row, col, cur, path);
                visited[row][col] = false;
            }
        }

        for (String str : ans)
            System.out.print(str + " ");
    }

    static boolean dfs(int r, int c, final Node cur, StringBuilder path) {
        if (cur.isEnd) {
            ans.add(path.toString());
            cur.isEnd = false;
            if (cur.children.size() == 0)
                return true;
        }
        int[][] bias = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        for (int[] b : bias) {
            int newr = r + b[0], newc = c + b[1];
            if (newr >= 0 & newr < m & newc >= 0 & newc < n
                    && !visited[newr][newc] & cur.children.containsKey(board[newr][newc])) {
                char next = board[newr][newc];
                visited[newr][newc] = true;
                path.append(next);
                if (dfs(newr, newc, cur.children.get(next), path))
                    cur.children.remove(next);
                visited[newr][newc] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
        if (cur.children.size() == 0)
            return true;
        return false;
    }
}
