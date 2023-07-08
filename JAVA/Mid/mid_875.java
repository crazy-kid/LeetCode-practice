package JAVA.Mid;

public class mid_875 {

    public static void main(String[] args) {
        int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };

        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0) {
                colors[i] = 1;
                if (!dfs(colors, graph, i)) {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }

    public static boolean dfs(int[] colors, int[][] graph, int node) {
        for (int neighbor : graph[node]) {
            if (colors[neighbor] == colors[node])
                return false;
            else if (colors[neighbor] == 0) {
                colors[neighbor] = -colors[node];
                if (!dfs(colors, graph, neighbor))
                    return false;
            }
        }
        return true;
    }
}