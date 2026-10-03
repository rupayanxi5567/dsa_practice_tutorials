package graphs_qns;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public boolean prerequisiteTasks(int n, int[][] pre) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : pre) {
            adj.get(edge[0]).add(edge[1]);
        }

        int []inDegree = new int[n];
        Deque<Integer>q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<adj.get(i).size();j++){
                inDegree[adj.get(i).get(j)]++;
            }
        }
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                q.addLast(i);
            }
        }

        while (!q.isEmpty()){
            int cn = q.pollFirst();
            res.addLast(cn);
            for(int i=0;i<adj.get(cn).size();i++){
                inDegree[adj.get(cn).get(i)]--;
                if(inDegree[adj.get(cn).get(i)]==0){
                    q.addLast(adj.get(cn).get(i));
                }
            }
        }
        return n== res.size();
    }
}
