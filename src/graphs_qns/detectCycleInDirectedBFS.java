package graphs_qns;

import java.util.*;

class Solution {
    public boolean isCyclic(int v, int[][] edges) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        int []inDegree = new int[v];
        for(int i=0;i<v;i++){
            for(int j=0;j<adj.get(i).size();j++){
                inDegree[adj.get(i).get(j)]++;
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i< inDegree.length;i++){
            if(inDegree[i]==0){
                q.addLast(i);
            }
        }
        while (!q.isEmpty()){
            int cn=q.pollFirst();
            res.add(cn);
            for(int i=0;i<adj.get(cn).size();i++){
                int nghr=adj.get(cn).get(i);
                inDegree[nghr]--;
                if(inDegree[nghr]==0){
                    q.addLast(nghr);
                }
            }
        }
        return res.size()!=v;
    }
}
