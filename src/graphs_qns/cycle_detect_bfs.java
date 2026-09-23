package graphs_qns;
import java.util.*;
class Pair{
    int v;
    int parent;
    public Pair(int v,int parent){
        this.v=v;
        this.parent=parent;
    }
}
class Solution {
    public boolean isCycle(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] vis = new int[v];
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                if(bfs_ans(i,adj,vis)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs_ans(int src,ArrayList<ArrayList<Integer>> adj, int[] vis) {
        Deque<Pair>q=new ArrayDeque<>();
        q.addLast(new Pair(src,-1));
        vis[src]=1;
        while (!q.isEmpty()){
            Pair cp = q.pollFirst();
            int cn = cp.v;
            int par = cp.parent;

            for(int i=0;i<adj.get(cn).size();i++){
                int neighbour=adj.get(cn).get(i);
                if(par==neighbour){
                    continue;
                }
                if(vis[neighbour]==1){
                    return true;
                }
                vis[neighbour]=1;
                q.addLast(new Pair(neighbour,cn));
            }
        }
        return false;
    }
}