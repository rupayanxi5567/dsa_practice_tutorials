package graphs_qns;
import java.util.*;

class Triplet{
    int node;
    int cost;
    int stops;

    public Triplet(int node,int cost,int stops){
        this.node=node;
        this.cost=cost;
        this.stops=stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] a, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] f : a) {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        PriorityQueue<Triplet>pq=new PriorityQueue<>((x,y)->Integer.compare(x.cost,y.cost));
        pq.add(new Triplet(src,0,0));

        int []minStops = new int[n];
        Arrays.fill(minStops,Integer.MAX_VALUE);

        while (!pq.isEmpty()){
            Triplet ct = pq.poll();
            int cn = ct.node;
            int cc = ct.cost;
            int cs = ct.stops;

            if(cn==dst){
                return cc;
            }

            if(minStops[cn]<=cs){
                continue;
            }
            minStops[cn]=cs;

            if(cs==k+1){
                continue;
            }

            for(int i=0;i<adj.get(cn).size();i++){
                int [] nghbr_info = adj.get(cn).get(i);
                int nghbr_node=nghbr_info[0];
                int nghbr_node_cost=nghbr_info[1];

                pq.add(new Triplet(nghbr_node,cc+nghbr_node_cost,cs+1));
            }
        }
        return -1;
    }
}
