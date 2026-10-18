package graphs_qns;

import java.util.*;

class DisjointSet {
    int[] par, size;

    public DisjointSet(int n) {
        par = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            size[i] = 1;
        }
    }

    public int find(int node) {
        if (node == par[node]) return node;
        return par[node] = find(par[node]);
    }

    public void union(int u, int v) {
        int pu = find(u), pv = find(v);
        if (pu == pv) return;
        if (size[pu] < size[pv]) {
            par[pu] = pv;
            size[pv] += size[pu];
        } else {
            par[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class Solution {
    public int maxRemove(int[][] stones) {
        int maxX = 0, maxY = 0;
        for (int[] s : stones) {
            maxX = Math.max(maxX, s[0]);
            maxY = Math.max(maxY, s[1]);
        }

        DisjointSet ds = new DisjointSet(maxX + maxY + 2);

        for (int[] s : stones) {
            ds.union(s[0], maxX + 1 + s[1]);
        }

        Set<Integer> roots = new HashSet<>();
        for (int[] s : stones) {
            roots.add(ds.find(s[0]));
        }

        return stones.length - roots.size();
    }
}