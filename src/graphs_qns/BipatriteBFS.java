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
        Deque<Integer>q=new ArrayDeque<>();

        for(int i=0;i<v;i++){
            if(col[i]==-1){
                if(!helper(i,col,q,adj)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean helper(int node, int[] col, Deque<Integer> q, ArrayList<ArrayList<Integer>> adj) {
        q.addLast(node);
        col[node]=0;
        while (!q.isEmpty()){
            int cn=q.pollFirst();
            for(int i=0;i<adj.get(cn).size();i++){
                int nghbr = adj.get(cn).get(i);
                if(col[nghbr]==-1){
                    q.addLast(nghbr);
                    col[nghbr]=1-col[cn];
                }else{
                    if(col[cn]==col[nghbr]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
