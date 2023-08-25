package JAVA.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class hard_127 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] tmp = { "hot", "dot", "dog", "lot", "log", "cog" };
        for (String str : tmp)
            wordList.add(str);

        // build graph
        HashMap<String, HashSet<String>> graph = new HashMap<String, HashSet<String>>();
        graph.put(beginWord, new HashSet<String>());
        for (String str : wordList)
            graph.put(str, new HashSet<String>());

        if (!graph.containsKey(endWord))
            return;
        graph.put(endWord, new HashSet<String>());

        for (String key : graph.keySet()) {
            StringBuilder sb = new StringBuilder(key);
            for (int i = 0; i < sb.length(); i++) {
                char old = sb.charAt(i);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == old)
                        continue;
                    sb.setCharAt(i, c);
                    if (graph.containsKey(sb.toString())) {
                        graph.get(key).add(sb.toString());
                    }
                }
                sb.setCharAt(i, old);
            }
        }

        Queue<String> queue1 = new LinkedList<String>();
        Queue<String> queue2 = new LinkedList<String>();
        HashSet<String> visit1 = new HashSet<String>();
        HashSet<String> visit2 = new HashSet<String>();
        queue1.add(beginWord);
        visit1.add(beginWord);
        queue2.add(endWord);
        visit2.add(endWord);
        int ans = 0;
        while (!queue1.isEmpty() & !queue2.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                String start = queue1.poll();
                for (String end : graph.get(start)) {
                    if (visit1.contains(end))
                        continue;
                    if (visit2.contains(end)) {
                        System.out.println(ans + 1);
                        return;
                    }
                    visit1.add(end);
                    queue1.add(end);
                }
            }
            ans++;
            size = queue2.size();
            for (int i = 0; i < size; i++) {
                String start = queue2.poll();
                for (String end : graph.get(start)) {
                    if (visit2.contains(end))
                        continue;
                    if (visit1.contains(end)) {
                        System.out.println(ans + 1);
                        return;
                    }
                    visit2.add(end);
                    queue2.add(end);
                }
            }
            ans++;
        }
        System.out.println(0);
    }
}
