package graphs_qns;

import java.util.*;

class triplet{
    int step;
    int row;
    int col;
    public triplet(int step,int row,int col){
        this.step=step;
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public int shortestPath(int[][] q, int[] src, int[] dest) {
        // code here
        int m=q.length;
        int n=q[0].length;

        int source_row=src[0];
        int source_col=src[1];

        int dest_row=dest[0];
        int dest_col=dest[1];

        if(q[source_row][source_col]==0 || q[dest_row][dest_col]==0){
            return -1;
        }

        int [][]d=new int[m][n];
        for (int[] row : d) Arrays.fill(row, Integer.MAX_VALUE);
        d[source_row][source_col]=0;

        int [][]exp=new int[m][n];

        PriorityQueue<triplet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.step, b.step));
        pq.add(new triplet(0,source_row,source_col));

        int []dr={0,-1,0,1};
        int []dc={-1,0,1,0};
        while (!pq.isEmpty()){
            triplet ct = pq.poll();
            int c_step = ct.step;
            int c_row = ct.row;
            int c_col = ct.col;

            if(exp[c_row][c_col]==1){
                continue;
            }

            exp[c_row][c_col]=1;

            for(int i=0;i<dr.length;i++){
                int nr = c_row+dr[i];
                int nc = c_col+dc[i];
                if((nr>=0 && nr<m && nc>=0 && nc<n) && (q[nr][nc]==1) && (c_step+1<d[nr][nc])){
                    pq.add(new triplet(c_step+1,nr,nc));
                    d[nr][nc]=c_step+1;
                }
            }
        }
        return d[dest_row][dest_col]==Integer.MAX_VALUE ? -1 : d[dest_row][dest_col];
    }
}
