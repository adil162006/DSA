import java.util.Arrays;

public class Kruskal {
    int minimumSpanningTree(int V,int[][]edges){
        DSU dsu = new DSU(V);
        int sum =0;
        Arrays.sort(edges,(a,b)->a[2]-b[2]);

        for(int edge[] : edges){
            int x = edge[0];
            int y = edge[1];
            int wt = edge[2];
            if(dsu.find(x)!=dsu.find(y)){
                dsu.union(x,y);
                sum+=wt;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Kruskal obj = new Kruskal();

        int V = 4;

        int[][] edges = {
                {0, 1, 10},
                {0, 2, 6},
                {0, 3, 5},
                {1, 3, 15},
                {2, 3, 4}
        };

        System.out.println(obj.minimumSpanningTree(V, edges));
    }
}
