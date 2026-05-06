import java.util.ArrayList;
import java.util.List;

public class Basic {
    static List<List<Integer>> createGraph(int n , List<List<Integer>>edges){
        List<List<Integer>> adj = new ArrayList<>();
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
return adj;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(List.of(0,1));
        edges.add(List.of(0,2));
        edges.add(List.of(1,3));
        List<List<Integer>> graph = createGraph(4, edges);

        System.out.println(graph);
    }
}
