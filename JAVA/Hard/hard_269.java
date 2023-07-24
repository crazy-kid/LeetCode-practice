package JAVA.Hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class hard_269 {

    static boolean[][] graph = new boolean[26][26];
    static HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
    static boolean valid = true;

    public static void main(String[] args) {
        String[] words = { "abc", "ab" };

        for (String word : words)
            for (char c : word.toCharArray())
                count.put(c - 'a', 0);

        for (int i = 0; i < words.length - 1; i++) {
            addEdge(words[i].toCharArray(), 0, words[i + 1].toCharArray(), 0);
        }
        printGraph();
        Queue<Integer> queue = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++)
            if (count.containsKey(i) && count.get(i) == 0) {
                queue.add(i);
                sb.append((char) (i + 'a'));
                count.remove(i);
            }
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 0; j < 26; j++) {
                if (graph[i][j]) {
                    count.put(j, count.get(j) - 1);
                    if (count.get(j) == 0) {
                        queue.add(j);
                        sb.append((char) (j + 'a'));
                        count.remove(j);
                    }
                }
            }
        }
        sb.reverse();
        for (int key : count.keySet())
            if (count.get(key) > 0) {
                System.out.println("");
                return;
            }
        for (int key : count.keySet()) {
            sb.append((char) (key + 'a'));
        }
        System.out.println(sb.toString());
    }

    public static void addEdge(char[] str1, int cur1, char[] str2, int cur2) {
        if (str1.length - cur1 != 0 && str2.length - cur2 == 0) {
            valid = false;
            return;
        }
        if (str1.length - cur1 == 0)
            return;
        if (str1[cur1] != str2[cur2]) {
            if (!graph[str2[cur1] - 'a'][str1[cur1] - 'a']) {
                count.put(str1[cur1] - 'a', count.get(str1[cur1] - 'a') + 1);
                graph[str2[cur1] - 'a'][str1[cur1] - 'a'] = true;
            }
        } else {
            addEdge(str1, cur1 + 1, str2, cur2 + 1);
        }
    }

    public static void printGraph() {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (graph[i][j])
                    System.out.println((char) (j + 'a') + " " + (char) (i + 'a'));
            }
        }
    }
}
