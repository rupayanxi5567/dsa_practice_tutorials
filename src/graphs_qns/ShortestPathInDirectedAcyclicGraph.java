package graphs_qns;

import java.util.*;

class Solution {
    public ArrayList<Integer> shortestPath(int n, int[][] edges) {
        // Code here
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});   // {neighbour, weight}
        }

        Deque<Integer>stk = new ArrayDeque<>();
        int []vis = new int[n];

        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs_helper(stk,vis,i,adj);
            }
        }

        int []dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        while (!stk.isEmpty()){
            int cn = stk.pop();
            int cw = dist[cn];

            for(int i=0;i<adj.get(cn).size();i++){
                int []info = adj.get(cn).get(i);
                int nghbr = info[0];
                int nghbr_weight = info[1];
                if(cw!=Integer.MAX_VALUE){
                    dist[nghbr] = Math.min(dist[nghbr],cw+nghbr_weight);
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i< dist.length;i++){
            res.add(dist[i]==Integer.MAX_VALUE ? -1 : dist[i]);
        }
        return res;
    }

    private void dfs_helper(Deque<Integer> stk, int[] vis, int node, List<List<int[]>> adj) {
        vis[node]=1;
        for(int i=0;i<adj.get(node).size();i++){
            int []edgeInfo = adj.get(node).get(i);
            int nghbr = edgeInfo[0];
            int weights = edgeInfo[1];
            if(vis[nghbr]==0){
                dfs_helper(stk,vis,nghbr,adj);
            }
        }
        stk.push(node);
    }
}