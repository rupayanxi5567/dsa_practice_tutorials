//package graphs_qns;
//
//import java.util.*;
//
//class Solution {
//    public boolean isCyclic(int V, int[][] edges) {
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//        for (int i = 0; i < V; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for (int[] edge : edges) {
//            int u = edge[0];
//            int v = edge[1];
//            adj.get(u).add(v);
//        }
//        int []path=new int[V];
//        int []vis=new int[V];
//        for(int i=0;i<V;i++){
//            if(vis[i]==0){
//                if(helper(adj,path,vis,i)){
//                    return true;
//                }
//            }
//        }
//        return false;
//
//    }
//
//    private boolean helper(ArrayList<ArrayList<Integer>> adj, int[] path, int[] vis,int node) {
//        vis[node]=1;
//        path[node]=1;
//        for(int i=0;i<adj.get(node).size();i++){
//            int nghbr = adj.get(node).get(i);
//            if(path[nghbr]==1){
//                return true;
//            }
//            if(vis[nghbr]==1){
//                continue;
//            }
//            if(helper(adj,path,vis,nghbr)){
//                return true;
//            }
//        }
//        path[node]=0;
//        return false;
//    }
//}