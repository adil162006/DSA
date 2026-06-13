import java.util.ArrayList;

public class CycleDetectionDirected {

    boolean cycle = false;

    void dfs(ArrayList<ArrayList<Integer>> adj,
             boolean[] vis,
             int[] path,
             int node) {

        vis[node] = true;
        path[node] = 1; // mark node in current DFS path

        for (int neigh : adj.get(node)) {

            // Back edge found => cycle exists
            if (vis[neigh] && path[neigh] == 1) {
                cycle = true;
                return;
            }

            if (!vis[neigh]) {
                dfs(adj, vis, path, neigh);

                if (cycle) return;
            }
        }

        path[node] = 0; // remove from current DFS path
    }

    boolean isCycle(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Directed graph
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            adj.get(src).add(dest);
        }

        boolean[] vis = new boolean[V];
        int[] path = new int[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(adj, vis, path, i);

                if (cycle) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        CycleDetectionDirected obj = new CycleDetectionDirected();

        int V = 4;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 1}
        };

        System.out.println("Cycle Present: " + obj.isCycle(V, edges));
    }
}