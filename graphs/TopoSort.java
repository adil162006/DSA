import java.util.*;
public class TopoSort {
    public ArrayList<Integer> topoSort(int V,int[][]edges){
        ArrayList<Integer>res = new ArrayList<>();
        int[] indeg=new int[V];
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge:edges){
            int src = edge[0];
            int des = edge[1];
            adj.get(src).add(des);
            indeg[des]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for (int i = 0; i <V ; i++) {
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        while (!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for (int i = 0; i <adj.get(node).size() ; i++) {
                int neigh = adj.get(node).get(i);
                indeg[neigh]--;
                if(indeg[neigh]==0)q.add(neigh);
            }
        }

        return res;
    }
}
