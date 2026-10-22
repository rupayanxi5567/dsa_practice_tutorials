//package graphs_qns;
//import java.util.*;
//
//class Pair{
//    int node;
//    int dist;
//    public Pair(int node,int dist){
//        this.node=node;
//        this.dist=dist;
//    }
//}
//
//class Solution {
//    public int countPaths(int v, int[][] edges) {
//        // code here
//        final int MOD = 1_000_000_007;
//        List<List<int[]>> adj = new ArrayList<>();
//        for (int i = 0; i < v; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for (int[] e : edges) {
//            adj.get(e[0]).add(new int[]{e[1], e[2]});
//            adj.get(e[1]).add(new int[]{e[0], e[2]});
//        }
//
//        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->Integer.compare(x.dist, y.dist));
//        pq.add(new Pair(0,0));
//
//        long [] dist=new long[v];
//        Arrays.fill(dist,Long.MAX_VALUE);
//        dist[0]=0;
//
//        long []ways=new long[v];
//        ways[0]=1;
//
//        while (!pq.isEmpty()){
//            Pair cp = pq.poll();
//            int cn=cp.node;
//            int cd=cp.dist;
//
//            if(cd>dist[cn]){
//                continue;
//            }
//
//            for(int i=0;i<adj.get(cn).size();i++){
//                int [] nghbr_info = adj.get(cn).get(i);
//                int new_node=nghbr_info[0];
//                int new_node_weight =nghbr_info[1];
//
//                if(cd+ new_node_weight <dist[new_node]){
//                    ways[new_node]=ways[cn];
//                    dist[new_node]= new_node_weight +cd;
//                    pq.add(new Pair(new_node, new_node_weight +cd));
//                }else if(cd+ new_node_weight ==dist[new_node]){
//                    ways[new_node] = (ways[new_node] + ways[cn]) % MOD;
//                }
//            }
//        }
//        return (int) (ways[v - 1] % MOD);
//    }
//}
//
