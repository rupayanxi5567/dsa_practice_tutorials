package graphs_qns;

import java.util.*;

class Solution {
    public ArrayList<Integer> safeNodes(int v, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        int []vis=new int[v];
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<v;i++){
            if(vis[i]==0){
                dfs_helper(i,vis,adj,res);
            }
        }
        return res;
    }

    private boolean dfs_helper(int node, int[] vis, List<List<Integer>> adj,ArrayList<Integer> res) {
        if(vis[node]==2){
            return true;
        }
        vis[node]=1;
        for(int i=0;i<adj.get(node).size();i++){
            int nghbr = adj.get(node).get(i);
            if(vis[nghbr]==1){
                return false;
            }
            if(vis[nghbr]==0){
                if(!dfs_helper(nghbr,vis,adj,res)){
                    return false;
                }
            }
        }
        vis[node]=2;
        res.add(node);
        return true;
    }
}
