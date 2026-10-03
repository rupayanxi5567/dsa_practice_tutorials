package graphs_qns;

import java.util.*;

class Solution {
    public String findOrder(String[] words) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Deque<Integer>q=new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }
        int n = words.length;
        for(int i=0;i<n-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            boolean misMatchFound = false;
            for(int j=0;j<Math.min(s1.length(),s2.length());j++){
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if(c1!=c2){
                    // c1 er node -> c2 er node
                    adj.get(c1-'a').add(c2-'a');
                    misMatchFound=true;
                    break;
                }
            }
            if(!misMatchFound && s1.length()>s2.length()){
                return "";
            }
        }

        int []inDegree = new int[26];

        for(int i=0;i<26;i++){
            for(int nghbr: adj.get(i)){
                inDegree[nghbr]++;
            }
        }

        int []present = new int[26];
        int presenCount=0;
        for(String word:words){
            for(char c:word.toCharArray()){
                present[c-'a']=1;
            }
        }
        for(int i=0;i<26;i++){
            if(present[i]==1){
                presenCount++;
            }
        }


        //  bfs started
        for(int i=0;i<26;i++){
            if(present[i]==1 && inDegree[i]==0){
                q.addLast(i);
            }
        }
        while (!q.isEmpty()){
            int cn = q.pollFirst();
            sb.append( (char) (cn+'a'));
            for(int i=0;i<adj.get(cn).size();i++){
                int nghbr = adj.get(cn).get(i);
                inDegree[nghbr]--;
                if(inDegree[nghbr]==0){
                    q.addLast(nghbr);
                }
            }
        }
        return sb.length()==presenCount? sb.toString() : "";

    }
}
