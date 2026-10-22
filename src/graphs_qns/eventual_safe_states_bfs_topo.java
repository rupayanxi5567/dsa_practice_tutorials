//package graphs_qns;
//import java.util.*;
//class Solution {
//    public ArrayList<Integer> safeNodes(int n, int[][] edges) {
//        // Code here
//        ArrayList<Integer> res = new ArrayList<>();
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for (int[] edge : edges) {
//            adj.get(edge[1]).add(edge[0]);
//        }
//
//        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            revAdj.add(new ArrayList<>());
//        }
//        for (int[] edge : edges) {
//            revAdj.get(edge[0]).add(edge[1]);
//        }
//
//        Deque<Integer> q = new ArrayDeque<>();
//        int[] outDegree = new int[n];
//        for (int i = 0; i < n; i++) {
//            outDegree[i] = revAdj.get(i).size();
//        }
//        for(int i=0;i<n;i++){
//            if(outDegree[i]==0){
//                q.addLast(i);
//            }
//        }
//
//        while (!q.isEmpty()){
//            int cn = q.pollFirst();
//            res.add(cn);
//            for(int i=0;i<adj.get(cn).size();i++){
//                int nghbr = adj.get(cn).get(i);
//                outDegree[nghbr]--;
//                if(outDegree[nghbr]==0){
//                    q.addLast(nghbr);
//                }
//            }
//        }
//        return res;
//    }
//}
