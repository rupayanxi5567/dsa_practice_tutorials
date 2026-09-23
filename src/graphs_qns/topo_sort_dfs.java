package graphs_qns;

import java.util.*;

class Solution {
    public ArrayList<Integer> topoSort(int v, int[][] edges) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        int[]vis=new int[v];
        Deque<Integer> stk = new ArrayDeque<>();
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                helper(res,adj,vis,stk,i);
            }
        }
        while (!stk.isEmpty()){
            res.add(stk.pop());
        }
        return res;
    }

    private void helper(ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj, int[] vis, Deque<Integer> stk, int v) {
        vis[v]=1;
        for(int i=0;i<adj.get(v).size();i++){
            int nghbr = adj.get(v).get(i);
            if(vis[nghbr]==0){
                helper(res,adj,vis,stk,nghbr);
            }
        }
        stk.push(v);
    }
}
