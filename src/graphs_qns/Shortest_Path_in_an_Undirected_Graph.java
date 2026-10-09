package graphs_qns;

import java.util.*;

class Solution {
    public ArrayList<Integer> shortestPath(int V, int[][] edges, int src, int dest) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int[] d = new int[V + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[dest] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{dest, 0});

        while (!pq.isEmpty()) {
            int[] cp = pq.poll();
            int cn = cp[0];
            int cd = cp[1];

            if (cd > d[cn]) continue;

            for (int[] nb : adj.get(cn)) {
                int nn = nb[0];
                int nw = nb[1];
                if (cd + nw < d[nn]) {
                    d[nn] = cd + nw;
                    pq.add(new int[]{nn, d[nn]});
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        if (d[src] == Integer.MAX_VALUE) {
            res.add(-1);
            return res;
        }

        int cur = src;
        res.add(cur);
        while (cur != dest) {
            int next = Integer.MAX_VALUE;
            for (int[] nb : adj.get(cur)) {
                int nn = nb[0];
                int nw = nb[1];
                if (d[nn] != Integer.MAX_VALUE && d[cur] == d[nn] + nw) {
                    next = Math.min(next, nn);
                }
            }
            res.add(next);
            cur = next;
        }
        return res;
    }
}