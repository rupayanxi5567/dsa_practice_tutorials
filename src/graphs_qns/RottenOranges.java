package graphs_qns;

import java.util.ArrayDeque;
import java.util.Deque;

class OrangePair{
    int row,col;
    public OrangePair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int orangesRot(int[][] mat) {
        int counter=0;
        int freshOrangeCounter=0;
        int rottenOrangeCounter = 0;
        int m=mat.length;;
        Deque<OrangePair>q=new ArrayDeque<>();
        int n=mat[0].length;;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==2){
                    q.addLast(new OrangePair(i,j));
                    rottenOrangeCounter++;
                }else if(mat[i][j]==1){
                    freshOrangeCounter++;
                }
            }
        }
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        while (!q.isEmpty()){
            int sizes=q.size();
            boolean flag=false;
            for(int k=1;k<=sizes;k++){
                OrangePair cp=q.pollFirst();
                int cr=cp.row;
                int cc=cp.col;
                for(int i=0;i< dr.length;i++){
                    int nr = cr+dr[i];
                    int nc = cc+dc[i];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]==1){
                        q.addLast(new OrangePair(nr,nc));
                        mat[nr][nc]=2;
                        flag=true;
                        freshOrangeCounter--;
                    }
                }
            }
            if(flag){
                counter++;
            }
        }
        return freshOrangeCounter==0 ? counter : -1;
    }

}
