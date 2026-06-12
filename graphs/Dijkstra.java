import java.util.*;
public class Dijkstra {
    class Pair {
        int node;
        int wt;

        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.wt - b.wt);

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int u = curr.node;
            int d = curr.wt;

            if (d > dist[u]) continue;

            for (Pair neigh : adj.get(u)) {

                int v = neigh.node;
                int wt = neigh.wt;

                if (dist[u] + wt < dist[v]) {

                    dist[v] = dist[u] + wt;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
    public static void main(String[] args) {

        int V = 5;

        int[][] edges = {
                {0, 1, 4},
                {0, 2, 1},
                {2, 1, 2},
                {1, 3, 1},
                {2, 3, 5},
                {3, 4, 3}
        };

        int src = 0;

        Dijkstra sol = new Dijkstra();
        int[] dist = sol.dijkstra(V, edges, src);

        System.out.println("Shortest distances from source " + src + ":");

        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " -> " + dist[i]);
        }
    }
}
