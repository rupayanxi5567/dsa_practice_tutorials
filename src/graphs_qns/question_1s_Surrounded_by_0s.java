package graphs_qns;

import java.util.ArrayDeque;
import java.util.Deque;

class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public int cntOnes(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis = new int[m][n];
        int counter = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && (i==0 || i==m-1 || j==0 || j==n-1)){
                    bfs_helper(i,j,grid,vis,m,n);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    vis[i][j]=1;
                }else if(grid[i][j]==1 && vis[i][j]==0){
                    counter++;
                }
            }
        }
        return counter;
    }

    private void bfs_helper(int i, int j, int[][] grid, int[][] vis, int m, int n) {
        Deque<Pair>q=new ArrayDeque<>();
        q.addLast(new Pair(i,j));
        vis[i][j]=1;
        int[]dr = {0,-1,0,1};
        int[]dc = {-1,0,1,0};
        while (!q.isEmpty()){
            Pair cp = q.pollFirst();
            int cr = cp.row;
            int cc = cp.col;
            for(int k=0;k<dr.length;k++){
                int nr = cr+dr[k];
                int nc = cc+dc[k];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && vis[nr][nc]==0){
                    q.addLast(new Pair(nr,nc));
                    vis[nr][nc]=1;
                }
            }
        }
    }
};
