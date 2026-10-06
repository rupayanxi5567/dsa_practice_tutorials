package graphs_qns;

import java.util.*;

class Pair{
    String word;
    int step;
    public Pair(String word,int step){
        this.word=word;
        this.step=step;
    }
}

class Solution {
    public int wordLadder(String[] words, String s, String e) {
        // code here
        Deque<Pair>q=new ArrayDeque<>();
        Set<String>sets=new HashSet<>(Arrays.asList(words));
        int step=1;
        q.addLast(new Pair(s,step));
        while (!q.isEmpty()){
            Pair cp = q.pollFirst();
            int cs = cp.step;
            String cw = cp.word;

            char[] chars = cw.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) continue;
                    chars[i] = c;
                    String newWord = new String(chars);
                    if(sets.contains(newWord)){
                        q.addLast(new Pair(newWord,cs+1));
                        sets.remove(newWord);
                        if(newWord.equals(e)){
                            return cs+1;
                        }
                    }
                }

                chars[i] = original;
            }

        }
        return 0;
    }
}
