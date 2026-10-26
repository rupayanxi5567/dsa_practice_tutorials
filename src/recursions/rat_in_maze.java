package recursions;

import java.util.ArrayList;
import java.util.List;

public class rat_in_maze {
    static void main(String[] args) {
        int[][] a = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        int m = a.length;
        int n = a[0].length;
        int[][] vis = new int[m][n];
        vis[0][0]=1;
        List<Character>al=new ArrayList<>();
        List<List<Character>>res=new ArrayList<>();
        helper(a,0,0,3,3,m,n,al,res,vis);
        System.out.println(res);
        System.out.println(res.size());
    }

    public static void helper(int[][] a, int row, int col, int end_row, int end_col, int m, int n, List<Character> al, List<List<Character>> res,int[][] vis) {
        if(row==end_row && col==end_col){
            res.add(new ArrayList<>(al));
            return;
        }

        int []dr={0,-1,0,1};
        int []dc={-1,0,1,0};
        char[] dir = {'L','U','R','D'};

        for(int k=0;k<dr.length;k++){
            int nr = row+dr[k];
            int nc = col+dc[k];
            if(nr>=0 && nr<m && nc>=0 && nc<n && a[nr][nc]==1 && vis[nr][nc]==0){
                al.add(dir[k]);
                vis[nr][nc]=1;
                helper(a,nr,nc,end_row,end_col,m,n, al, res, vis);
                vis[nr][nc]=0;
                al.removeLast();
            }
        }

    }
}
