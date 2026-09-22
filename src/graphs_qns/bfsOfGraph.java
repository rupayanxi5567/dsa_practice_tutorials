package graphs_qns;

import java.util.ArrayDeque;
import java.util.*;

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Deque<Integer>q=new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        int[] v=new int [adj.size()];
        q.addLast(0);
        v[0]=1;
        while (!q.isEmpty()){
            int cn = q.pollFirst();
            res.add(cn);
            for(int i=0;i<adj.get(cn).size();i++){
                if(v[adj.get(cn).get(i)]==0){
                    q.addLast(adj.get(cn).get(i));
                    v[adj.get(cn).get(i)]=1;
                }
            }
        }
        return res;
    }
}
