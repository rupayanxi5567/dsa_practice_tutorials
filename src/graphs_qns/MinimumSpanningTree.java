package graphs_qns;
import java.util.*;

class TripletForMst{
    int wt;
    int node;
    int parent;
    public TripletForMst(int wt, int node, int parent) {
        this.wt = wt;
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    public int spanningTree(int v, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[2], e[1]});
            adj.get(e[1]).add(new int[]{e[2], e[0]});
        }

        int cost=0;

        int []isMst=new int[v];

        int []par=new int[v];
        par[0]=-1;

        PriorityQueue<TripletForMst>pq=new PriorityQueue<>((x,y)->Integer.compare(x.wt,y.wt));
        pq.add(new TripletForMst(0,0,-1));

        while (!pq.isEmpty()){
            TripletForMst ct = pq.poll();
            int cwt = ct.wt;
            int cn = ct.node;
            int cp = ct.parent;

            if(isMst[cn]==1){
                continue;
            }

            isMst[cn]=1;
            par[cn]=cp;
            cost+=cwt;

            for(int i=0;i<adj.get(cn).size();i++){
                int[] nghbr_info = adj.get(cn).get(i);
                int nghbr_wt=nghbr_info[0];
                int nghbr_node=nghbr_info[1];

                if(isMst[nghbr_node]==0){
                    pq.add(new TripletForMst(nghbr_wt,nghbr_node,cn));
                }
            }
        }
        return cost;
    }
}