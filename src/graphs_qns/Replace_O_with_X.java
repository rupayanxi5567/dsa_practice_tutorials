package graphs_qns;

import java.util.ArrayDeque;
import java.util.Deque;

class Pair{
    int r,c;
    public Pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}

class Solution {
    public void fill(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][] vis = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || i==m-1 || j==0 || j==n-1) && grid[i][j]=='O' ){
                    bfs_helper(i,j,vis,m,n,grid);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='X'){
                    vis[i][j]=1;
                }else if(grid[i][j]=='O' && vis[i][j]==0){
                    grid[i][j]='X';
                    vis[i][j]=1;
                }
            }
        }
    }

    private void bfs_helper(int i, int j, int[][] vis, int m, int n,char[][] grid) {
        Deque<Pair>q=new ArrayDeque<>();
        q.addLast(new Pair(i,j));
        vis[i][j]=1;
        int []dr={-1,1,0,0};
        int []dc={0,0,-1,1};
        while (!q.isEmpty()){
            Pair cp = q.pollFirst();
            int cr = cp.r;
            int cc = cp.c;
            for(int k=0;k<dr.length;k++){
                int nr = cr+dr[k];
                int nc = cc+dc[k];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='O' && vis[nr][nc]==0 ){
                    q.addLast(new Pair(nr,nc));
                    vis[nr][nc]=1;
                }
            }
        }
    }
}
