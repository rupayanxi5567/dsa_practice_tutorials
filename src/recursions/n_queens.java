package recursions;

import java.util.*;
import java.util.List;

public class n_queens {
    static void main() {
        int n=5;

        char [][]a=new char[n][n];

        for (char[] r : a) Arrays.fill(r, '.');

        int[] cols=new int[n];
        int[] d1=new int[2*n-1];
        int[] d2=new int[2*n-1];

        List<String>al=new ArrayList<>();
        List<List<String>>res=new ArrayList<>();

        helper(0, n, a, cols, d1, d2, res);

        System.out.println(res);
        System.out.println(res.size());
    }
    public static void helper(int row, int n, char[][] a, int[] cols, int[] d1, int[] d2,List<List<String>> res) {
        if(row==n){
            List<String>al=new ArrayList<>();
            for(int i=0;i<n;i++){
                al.add(new String(a[i]));
            }
            res.add(al);
            return;
        }

        for(int col=0;col<n;col++){
            if(a[row][col]=='.' && 0==cols[col] && d1[col+row]==0 && d2[row-col+n-1]==0){
                a[row][col]='Q';
                cols[col]=1;
                d1[col+row]=1;
                d2[row-col+n-1]=1;

                helper(row+1, n, a, cols, d1, d2, res);

                a[row][col]='.';
                cols[col]=0;
                d1[col+row]=0;
                d2[row-col+n-1]=0;
            }
        }

    }
}
