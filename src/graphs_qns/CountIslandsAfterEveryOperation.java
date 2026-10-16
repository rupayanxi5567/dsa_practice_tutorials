package graphs_qns;
import java.util.*;

class Solution {

    private int find(int node, int[] par) {
        if (node == par[node]) return node;
        return par[node] = find(par[node], par);
    }

    private boolean union(int u, int v, int[] par, int[] rank) {
        int pu = find(u, par);
        int pv = find(v, par);
        if (pu == pv) return false;
        if (rank[pu] < rank[pv]) {
            par[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            par[pv] = pu;
        } else {
            par[pv] = pu;
            rank[pu]++;
        }
        return true;
    }

    public ArrayList<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        int[] par = new int[rows * cols];
        int[] rank = new int[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            par[i] = i;
        }

        ArrayList<Integer>res=new ArrayList<>();

        int counter=0;

        int[][] land = new int[rows][cols];

        int []dr={0,-1,0,1};
        int []dc={-1,0,1,0};

        for (int[] op : operators){

            int r=op[0];
            int c=op[1];

            if(land[r][c]==1){
                res.add(counter);
                continue;
            }

            land[r][c]=1;
            counter++;

            for(int i=0;i< dr.length;i++){
                int nr = r+dr[i];
                int nc = c+dc[i];

                if(nr>=0 && nr<rows && nc>=0 && nc<cols && land[nr][nc]==1){
                    if(union(r*cols+c,nr*cols+nc,par,rank)){
                        counter--;
                    }
                }
            }
            res.add(counter);
        }
        return res;
    }
}
