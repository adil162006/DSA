import java.util.*;

public class CycleDetectionAD {

    boolean res = false;

    void dfs(boolean[] vis, ArrayList<ArrayList<Integer>> adj,
             int node, int parent) {

        vis[node] = true;

        for (int neigh : adj.get(node)) {

            if (vis[neigh] && neigh != parent) {
                res = true;
            }

            if (!vis[neigh]) {
                dfs(vis, adj, neigh, node);
            }
        }
    }

    public boolean isCycle(int v, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];

            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }

        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(vis, adj, i, -1);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        CycleDetectionAD obj = new CycleDetectionAD();

        // Graph with cycle
        int[][] edges1 = {
                {0, 1},
                {1, 2},
                {2, 0},
                {2, 3}
        };

        System.out.println(obj.isCycle(4, edges1));
        // true

        // Graph without cycle
        CycleDetectionAD obj2 = new CycleDetectionAD();

        int[][] edges2 = {
                {0, 1},
                {1, 2},
                {2, 3}
        };

        System.out.println(obj2.isCycle(4, edges2));
        // false
    }
}