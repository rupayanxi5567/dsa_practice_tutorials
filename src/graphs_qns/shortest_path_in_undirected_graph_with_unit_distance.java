package graphs_qns;
import java.util.*;

class Pair{
    int node;
    int weights;
    public Pair(int node,int weights){
        this.node=node;
        this.weights=weights;
    }
}

class Solution {
    public ArrayList<Integer> shortestPath(int n, int[][] edges, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int []dists = new int[n];
        Arrays.fill(dists,Integer.MAX_VALUE);
        dists[src]=0;

        Deque<Pair>q=new ArrayDeque<>();
        q.addLast(new Pair(src,0));

        while (!q.isEmpty()){
            Pair cp = q.pollFirst();
            int cn = cp.node;
            int cw = cp.weights;
            for(int i=0;i<adj.get(cn).size();i++){
                int nghbr = adj.get(cn).get(i);
                if(dists[nghbr]==Integer.MAX_VALUE){
                    q.addLast(new Pair(nghbr,cw+1));
                    dists[nghbr]=cw+1;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i< dists.length;i++){
            res.add(dists[i]==Integer.MAX_VALUE ? -1 : dists[i]);
        }
        return res;
    }
}