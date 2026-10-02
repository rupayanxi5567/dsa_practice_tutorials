package graphs_qns;

import java.util.*;

class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public int countDistinctIslands(char[][] grid) {
        // code here
        int m = grid.length;;
        int n = grid[0].length;;

        int vis[][] = new int[m][n];
        Set<String>set=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='L' && vis[i][j]==0){
                    bfs_helper(i,j,vis,m,n,set,grid);
                }
            }
        }
        return set.size();
    }

    private void bfs_helper(int i, int j, int[][] vis, int m, int n, Set<String> set, char[][] grid) {
        Deque<Pair>q=new ArrayDeque<>();
        int base_row=i;
        int base_col=j;
        q.addLast(new Pair(i,j));
        vis[i][j]=1;
        int []dr = {0,-1,0,1};
        int []dc = {-1,0,1,0};
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()){
            Pair cp = q.pollFirst();
            int cr = cp.row;
            int cc = cp.col;
            int rel_row = cr-base_row;
            int rel_col = cc-base_col;
            sb.append(rel_row).append("-").append(rel_col).append(",");
            for(int k=0;k< dr.length;k++){
                int nc = cc+dc[k];
                int nr = cr+dr[k];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='L' && vis[nr][nc]==0){
                    q.addLast(new Pair(nr,nc));
                    vis[nr][nc]=1;
                }
            }
        }
        set.add(sb.toString());
    }
}
