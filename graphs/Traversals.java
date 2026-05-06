import java.util.*;
public class Traversals {
    static List<Integer> dfs(List<List<Integer>>adj,List<Integer>temp,boolean[]visited,int node){
        temp.add(node);
        visited[node]=true;

        for (int i = 0; i <adj.get(node).size() ; i++) {
            int neigh = adj.get(node).get(i);
            if(!visited[neigh]){
                dfs(adj,temp,visited,neigh);
            }

        }
        return temp;
    }
   static List<Integer> bfs(List<List<Integer>>adj){
        List<Integer> temp = new ArrayList<>();
        Queue<Integer>q = new LinkedList<>();
        boolean[]visited = new boolean[adj.size()];

        q.add(0);

        while(!q.isEmpty()){
            int node = q.remove() ;
            temp.add(node);

            for (int i = 0; i <adj.get(node).size(); i++) {
                int neigh = adj.get(node).get(i);
                if(!visited[neigh]){
                    q.add(neigh);
                    visited[node] = true;

                }

            }
        }

        return  temp;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        edges.add(List.of(0,1));
        edges.add(List.of(0,2));
        edges.add(List.of(1,3));
        int n = 4 ;
        for (int i = 0; i <n ; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            List<Integer> edge = edges.get(i);
            int src = edge.get(0);
            int dest = edge.get(1);

            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        boolean[]visited = new boolean[n];
        List<Integer> diary = new ArrayList<>();
        List<Integer> dfsTraversal = dfs(adj,diary,visited,0) ;
        System.out.println("==============DFS===========");
        System.out.println(dfsTraversal);
        List<Integer> bfsTraversal = bfs(adj);
        System.out.println("=================BFS====================");
        System.out.println(bfsTraversal);
    }
}
