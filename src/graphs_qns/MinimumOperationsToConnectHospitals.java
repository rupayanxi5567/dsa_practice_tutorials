package graphs_qns;

class Solution {
    public int minConnect(int V, int[][] edges) {
        // code here
        int m=edges.length;

        int countExtraEdges=0;
        int countConncectedComponents=0;

        int []rankArr=new int[V];

        int []parnetArr=new int[V];
        for(int i=0;i<V;i++)
            parnetArr[i]=i;

        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(findUltimateParent(u,parnetArr)==findUltimateParent(v,parnetArr)){
                countExtraEdges++;
            }else{
                unionByRank(u,v,parnetArr,rankArr);
            }
        }

        for(int i=0;i<V;i++){
            if(i==findUltimateParent(i,parnetArr)){
                countConncectedComponents++;
            }
        }

        int ans = countConncectedComponents-1;

        if(ans<=countExtraEdges){
            return ans;
        }else{
            return -1;
        }

    }

    private void unionByRank(int u, int v, int[] parnetArr, int[] rankArr) {
        int pu = findUltimateParent(u,parnetArr);
        int pv = findUltimateParent(v,parnetArr);

        if(pu==pv){
            return;
        }

        if(rankArr[pu]<rankArr[pv]){
            parnetArr[pu]=pv;
        }else if(rankArr[pu]>rankArr[pv]){
            parnetArr[pv]=pu;
        }else{
            parnetArr[pv]=pu;
            rankArr[pu]++;
        }
    }

    private int findUltimateParent(int node,int[]parnetArr) {
        if(node==parnetArr[node]){
            return node;
        }
        return parnetArr[node]=findUltimateParent(parnetArr[node],parnetArr);
    }
}

