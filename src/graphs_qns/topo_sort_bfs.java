//package graphs_qns;
//
//import java.util.*;
//
//class Solution {
//    public ArrayList<Integer> topoSort(int v, int[][] edges) {
//        // code here
//        ArrayList<Integer> res = new ArrayList<>();
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//        for (int i = 0; i < v; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for (int[] edge : edges) {
//            adj.get(edge[0]).add(edge[1]);
//        }
//        int [] inDegree = new int[v];
//        for(int i=0;i<v;i++){
//            for(int j=0;j<adj.get(i).size();j++){
//                inDegree[adj.get(i).get(j)]+=1;
//            }
//        }
//        Deque<Integer>q=new ArrayDeque<>();
//        for(int i=0;i<v;i++){
//            if(inDegree[i]==0){
//                q.addLast(i);
//            }
//        }
//
//        while (!q.isEmpty()){
//            int cn=q.pollFirst();
//            res.add(cn);
//            for(int i=0;i<adj.get(cn).size();i++){
//                int nghbr=adj.get(cn).get(i);
//                inDegree[nghbr]--;
//                if(inDegree[nghbr]==0){
//                    q.addLast(nghbr);
//                }
//            }
//        }
//        return res;
//    }
//}
