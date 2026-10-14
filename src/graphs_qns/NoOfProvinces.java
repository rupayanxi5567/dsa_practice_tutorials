package graphs_qns;

import java.util.*;

class Solution {
    int countConnected(int v, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int w = edges.get(i).get(1);
            adj.get(u).add(w);
            adj.get(w).add(u);
        }

        int[] vis = new int[v];
        int counter = 0;
        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                counter++;
                helper(i, vis, adj);
            }
        }
        return counter;
    }

    private void helper(int node, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int nghbr = adj.get(node).get(i);
            if (vis[nghbr] == 0) {
                helper(nghbr, vis, adj);
            }
        }
    }
}