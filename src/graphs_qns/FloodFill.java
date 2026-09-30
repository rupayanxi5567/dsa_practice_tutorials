package graphs_qns;

import java.util.ArrayDeque;
import java.util.Deque;

class Pair{
    int row,col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] floodFill(int[][] img, int sr, int sc, int newColor) {
        int originalColor = img[sr][sc];
        if(originalColor==newColor){
            return img;
        }
        img[sr][sc]=newColor;
        Deque<Pair>q=new ArrayDeque<>();
        q.addLast(new Pair(sr,sc));
        int []dr={-1,1,0,0};
        int []dc={0,0,-1,1};
        int m= img.length;;
        int n= img[0].length;;
        while (!q.isEmpty()){
            Pair cp = q.pollFirst();
            int cr=cp.row;
            int cc=cp.col;
            for(int i=0;i<dr.length;i++){
                    int nr = cr+dr[i];
                    int nc = cc+dc[i];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && img[nr][nc]==originalColor){
                        q.addLast(new Pair(nr,nc));
                        img[nr][nc]=newColor;
                    }
                }
            }
        return img;
    }
    }
