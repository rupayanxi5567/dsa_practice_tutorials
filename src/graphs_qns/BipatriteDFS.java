package graphs_qns;

import java.util.*;

class Solution {
    public boolean isBipartite(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int []col = new int[v];
        Arrays.fill(col,-1);

        int src = -1;

        for(int i=0;i<v;i++){
            if(col[i]==-1){
                if(!helper(src,i,col,adj)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean helper(int parent,int node, int[] col, ArrayList<ArrayList<Integer>> adj) {
        if(col[node]!=-1){
            return col[node]!=col[parent];
        }
        col[node] = parent==-1?0:1-col[parent];

        for(int i=0;i<adj.get(node).size();i++){
            int nghbr = adj.get(node).get(i);
            if(parent==nghbr){
                continue;
            }
            if(!helper(node,nghbr,col,adj)){
                return false;
            }
        }
        return true;
    }
}
