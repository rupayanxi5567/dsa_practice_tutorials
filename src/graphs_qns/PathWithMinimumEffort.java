package graphs_qns;
import java.util.*;

class Triplets{
    int row;
    int col;
    int steps;
    public Triplets(int row,int col,int steps){
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
}

class Solution {
    public int minCostPath(int[][] a) {
        // code here
        int m=a.length;
        int n=a[0].length;

        int [][]d=new int[m][n];
        for (int[] row : d) Arrays.fill(row, Integer.MAX_VALUE);
        d[0][0]=0;

        PriorityQueue<Triplets>pq=new PriorityQueue<>((x,y)->Integer.compare(x.steps,y.steps));
        pq.add(new Triplets(0,0,0));

        int dr[]={0,-1,0,1};
        int dc[]={-1,0,1,0};

        while (!pq.isEmpty()){
            Triplets ct = pq.poll();
            int cr = ct.row;
            int cc = ct.col;
            int cs = ct.steps;

            for(int i=0;i<dr.length;i++){
                int nr = cr+dr[i];
                int nc = cc+dc[i];

                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int step_diff = Math.abs(a[cr][cc]-a[nr][nc]);
                    int eff = Math.max(cs,step_diff);
                    if(eff<d[nr][nc]){
                        d[nr][nc]=eff;
                        pq.add(new Triplets(nr,nc,eff));
                    }
                }
            }
        }
        return d[m][n];
    }
}

