package graphs_qns;
import java.util.*;

class Pair{
    int nodes;
    int dist;
    public Pair(int nodes,int dist){
        this.nodes=nodes;
        this.dist=dist;
    }
}

class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int[]exp=new int[V];

        int[]d=new int[V];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[src]=0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Pair(src,0));

        while (!pq.isEmpty()){
            Pair cp = pq.poll();
            int cn = cp.nodes;
            int cd = cp.dist;

            if(exp[cn]==1){
                continue;
            }
            exp[cn]=1;

            for(int i=0;i<adj.get(cn).size();i++){
                int[] nghbr_info = adj.get(cn).get(i);
                int n_node=nghbr_info[0];
                int n_wt=nghbr_info[1];

                if(exp[n_node]==0 && n_wt+cd<d[n_node]){
                    d[n_node]=n_wt+cd;
                    pq.add(new Pair(n_node,d[n_node]));
                }
            }
        }

        ArrayList<Integer>res=new ArrayList<>();
        for(int i=0;i<V;i++){
            res.add(d[i]);
        }
        return res;
    }
}