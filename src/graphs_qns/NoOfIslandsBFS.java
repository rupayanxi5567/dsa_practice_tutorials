package graphs_qns;

import java.util.ArrayDeque;
import java.util.Deque;

class Pairs{
    int row;
    int col;
    public Pairs(int row, int col){
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public int countIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int [][] vis = new int[m][n];
        int counter = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='L' && vis[i][j]==0){
                    counter++;
                    bfs_helper(i,j,grid,vis,m,n);
                }
            }
        }
        return counter;
    }

    private void bfs_helper(int i, int j, char[][] grid, int[][] vis, int m, int n) {
        Deque<Pairs>q=new ArrayDeque<>();
        q.addLast(new Pairs(i,j));
        vis[i][j]=1;
        int []dr={-1,-1,-1,0,0,1,1,1};
        int []dc={-1,0,1,-1,1,-1,0,1};
        while (!q.isEmpty()){
            Pairs cp = q.pollFirst();
            int cr=cp.row;
            int cc=cp.col;
            for(int k=0;k<dr.length;k++){
                int newRow = cr+dr[k];
                int newCol = cc+dc[k];
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]=='L' && vis[newRow][newCol]==0){
                    q.addLast(new Pairs(newRow,newCol));
                    vis[newRow][newCol]=1;
                }
            }

        }
    }
}
