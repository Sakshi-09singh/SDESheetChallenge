package Day19;

public class MColoringPattern {
    boolean graphColoring(int[][] edges, int m, int n) {

        // Create adjacency matrix
        boolean[][] graph = new boolean[n][n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u][v] = true;
            graph[v][u] = true;
        }

        int[] color = new int[n];

        return solve(0, graph, color, m, n);
    }

    boolean solve(int node, boolean[][] graph, int[] color, int m, int n) {

        // All nodes colored
        if (node == n)
            return true;

        // Try all colors
        for (int c = 1; c <= m; c++) {

            if (isSafe(node, graph, color, c, n)) {

                color[node] = c;

                if (solve(node + 1, graph, color, m, n))
                    return true;

                // Backtrack
                color[node] = 0;
            }
        }

        return false;
    }

    boolean isSafe(int node, boolean[][] graph, int[] color, int c, int n) {

        for (int k = 0; k < n; k++) {

            if (graph[node][k] && color[k] == c)
                return false;
        }

        return true;
    }
}