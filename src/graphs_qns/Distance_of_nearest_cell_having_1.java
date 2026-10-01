package graphs_qns;

import java.util.*;
class Pair{
    int r,c,counter;
    public Pair(int r,int c,int counter){
        this.r=r;
        this.c=c;
        this.counter=counter;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int m = grid.length;;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int[][] res = new int[m][n];
        Deque<Pair>q=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    res[i][j]=0;
                    q.addLast(new Pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        int []dr={-1,1,0,0};
        int []dc={0,0,-1,1};
        while (!q.isEmpty()){
            int sizes = q.size();
            for(int i=1;i<=sizes;i++){
                Pair cp = q.pollFirst();
                int cr=cp.r;
                int cc=cp.c;
                int c_counter=cp.counter;
                for(int k=0;k<dr.length;k++){
                    int nr=cr+dr[k];
                    int nc=cc+dc[k];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0){
                        res[nr][nc]=c_counter+1;
                        q.addLast(new Pair(nr,nc,c_counter+1));
                        vis[nr][nc]=1;
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<m;i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(res[i][j]);
            }
            result.add(row);
        }
        return result;
    }
}
