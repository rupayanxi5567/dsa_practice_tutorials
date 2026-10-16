package graphs_qns;

import java.util.*;

class Solution {

    public static int counter=0;

    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int []par=new int[V];
        for(int i=0;i<V;i++){
            par[i]=i;
        }

        for(int i=0;i<V;i++){
            findUltimateParent(i,par,counter);
        }

        return counter;

    }

    private void findUltimateParent(int node, int[] par, int counter) {
        if(node==par[node]){
            counter++;
            return;
        }
        findUltimateParent(par[node],par,counter);
    }
}
