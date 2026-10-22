//package graphs_qns;
//
//class DisjointSet {
//    int[] par, size;
//
//    public DisjointSet(int n) {
//        par = new int[n];
//        size = new int[n];
//        for (int i = 0; i < n; i++) {
//            par[i] = i;
//            size[i] = 1;
//        }
//    }
//
//    public int find(int node) {
//        if (node == par[node]) return node;
//        return par[node] = find(par[node]);
//    }
//
//    public void union(int u, int v) {
//        int pu = find(u), pv = find(v);
//        if (pu == pv) return;
//        if (size[pu] < size[pv]) {
//            par[pu] = pv;
//            size[pv] += size[pu];
//        } else {
//            par[pv] = pu;
//            size[pu] += size[pv];
//        }
//    }
//}
