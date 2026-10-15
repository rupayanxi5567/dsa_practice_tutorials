package graphs_qns;
import java.util.*;

class TripletForMst{
    int wt;
    int u;
    int v;
    public TripletForMst(int wt, int u, int v) {
        this.wt = wt;
        this.u = u;
        this.v = v;
    }
}

class Solution {

    public int findUltimateParent(int node,int []par){
        if(node==par[node]){
            return node;
        }
        return par[node]=findUltimateParent(par[node],par);
    }

    public void findUnionByRank(int pu,int pv, int[]par,int[]rank){
        if(rank[pu]>rank[pv]){
            par[pv]=pu;
        }else if(rank[pv]>rank[pu]){
            par[pu]=pv;
        }else{
            par[pv]=pu;
            rank[pu]++;
        }
    }

    public int spanningTree(int v, int[][] edges) {
        int []par=new int[v];
        for(int i=0;i<v;i++){
            par[i]=i;
        }

        int [] ranks=new int[v];

        PriorityQueue<TripletForMst>pq=new PriorityQueue<>((x,y)->Integer.compare(x.wt,y.wt));
        for (int[] e : edges) {
            pq.add(new TripletForMst(e[2], e[0], e[1]));
        }

        int cost=0;

        while (!pq.isEmpty()){
            TripletForMst ct = pq.poll(); //    wt, node, par

            int curr_wt=ct.wt;
            int pu=findUltimateParent(ct.u,par);
            int pv=findUltimateParent(ct.v,par);

            if(pu!=pv){
                cost+=curr_wt;
                findUnionByRank(pu,pv,par,ranks);
            }
        }
        return cost;
    }
}