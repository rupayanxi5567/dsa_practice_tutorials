package graphs_qns;
import java.util.ArrayList;

class Solution {
    private boolean helper(int v, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[v] = 1;
        for (int i = 0; i < adj.get(v).size(); i++) {
            int neighbor = adj.get(v).get(i);
            if (parent == neighbor) {
                continue;
            }
            if (vis[neighbor] == 1) {
                return true;
            }
            if (helper(neighbor, v, vis, adj)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (helper(i, -1, vis, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
}