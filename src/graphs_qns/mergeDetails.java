package graphs_qns;

import java.util.*;

class Solution {

    private int find(int node, int[] par) {
        if (node == par[node]) return node;
        return par[node] = find(par[node], par);
    }

    private void unionBySize(int u, int v, int[] par, int[] size) {
        int pu = find(u, par);
        int pv = find(v, par);
        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            par[pu] = pv;
            size[pv] += size[pu];
        } else {
            par[pv] = pu;
            size[pu] += size[pv];
        }
    }

    public ArrayList<ArrayList<String>> mergeDetails(String[][] details) {
        int n = details.length;

        int[] par = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            size[i] = 1;
        }

        Map<String, Integer> firstSeen = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < details[i].length; j++) {
                String email = details[i][j];
                if (firstSeen.containsKey(email)) {
                    unionBySize(i, firstSeen.get(email), par, size);
                } else {
                    firstSeen.put(email, i);
                }
            }
        }

        Map<Integer, TreeSet<String>> emailsOf = new HashMap<>();
        Map<Integer, String> nameOf = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i, par);

            if (!nameOf.containsKey(root)) {
                nameOf.put(root, details[i][0]);
                emailsOf.put(root, new TreeSet<>());
            }
            for (int j = 1; j < details[i].length; j++) {
                emailsOf.get(root).add(details[i][j]);
            }
        }

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for (int root : emailsOf.keySet()) {
            ArrayList<String> row = new ArrayList<>();
            row.add(nameOf.get(root));
            row.addAll(emailsOf.get(root));
            res.add(row);
        }

        Collections.sort(res, (a, b) -> {
            int len = Math.min(a.size(), b.size());
            for (int k = 0; k < len; k++) {
                int c = a.get(k).compareTo(b.get(k));
                if (c != 0) return c;
            }
            return Integer.compare(a.size(), b.size());
        });

        return res;
    }
}