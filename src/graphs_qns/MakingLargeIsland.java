package graphs_qns;

import java.util.*;

class Solution {
    public int maxConnection(int grid[][]) {
        // code here
        int m = grid.length;
        int n = grid[0].length;
        int ans=0;

        DisjointSet ds = new DisjointSet(m*n);

        int []dr={0,-1,0,1};
        int []dc={-1,0,1,0};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int k=0;k<dr.length;k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                            ds.union(i*n+j,nr*n+nc);
                        }
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    int total=1;
                    Set<Integer> sets=new HashSet<>();
                    for(int k=0;k<dr.length;k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                            int root = ds.find(nr*n+nc);
                            if(!sets.contains(root)){
                                sets.add(root);
                                total+=ds.size[root];
                            }
                        }
                    }
                    ans=Math.max(ans,total);
                }
            }
        }
        return ans==0 ? m*n : ans;
    }
}
