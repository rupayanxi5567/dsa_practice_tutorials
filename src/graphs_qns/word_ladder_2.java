package graphs_qns;

import java.util.*;

class Solution {
    Map<String, Integer> level = new HashMap<>();
    List<List<String>> res = new ArrayList<>();
    String start;

    public ArrayList<ArrayList<String>> findSequences(String[] words, String s, String e) {
        level.clear();
        res.clear();
        start = s;
        Set<String> set = new HashSet<>(Arrays.asList(words));

        if (!set.contains(e)) return new ArrayList<>();

        Deque<String> q = new ArrayDeque<>();
        q.addLast(s);
        level.put(s, 1);
        set.remove(s);

        while (!q.isEmpty()) {
            String cw = q.pollFirst();
            int cl = level.get(cw);
            if (cw.equals(e)) break;

            char[] chars = cw.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) continue;
                    chars[i] = c;
                    String nw = new String(chars);
                    if (set.contains(nw)) {
                        q.addLast(nw);
                        level.put(nw, cl + 1);
                        set.remove(nw);
                    }
                }
                chars[i] = original;
            }
        }

        if (!level.containsKey(e)) return new ArrayList<>();

        ArrayList<String> path = new ArrayList<>();
        path.add(e);
        dfs(e, path);

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (List<String> p : res) ans.add(new ArrayList<>(p));
        return ans;
    }

    private void dfs(String word, ArrayList<String> path) {
        if (word.equals(start)) {
            List<String> copy = new ArrayList<>(path);
            Collections.reverse(copy);
            res.add(copy);
            return;
        }

        int curLevel = level.get(word);
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;
                chars[i] = c;
                String nw = new String(chars);

                Integer nl = level.get(nw);
                if (nl != null && nl == curLevel - 1) {
                    path.add(nw);
                    dfs(nw, path);
                    path.remove(path.size() - 1);
                }
            }
            chars[i] = original;
        }
    }
}