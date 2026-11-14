package dp_qns;

public class Min_path_sum {
    static void main(String[] args) {
        int [][] grid = {
                {5,9,6},
                {11,5,2}
        };
        int m=grid.length;
        int n=grid[0].length;

        int endI=m-1;
        int endJ=n-1;

        System.out.println(helper(endI,endJ,grid));;

        int [][] dp = new int[m][n];
        System.out.println(top_down_helper(endI,endJ,grid,dp));;

        int [][] dp1 = new int[m][n];
        System.out.println(bottom_up_helper(endI,endJ,grid,dp1));;
    }

    private static int bottom_up_helper(int i, int j, int[][] grid, int[][] dp) {
        int m=grid.length;
        int n=grid[0].length;

        for(i=0;i<m;i++){
            for( j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j] = grid[0][0];
                }else{
                    int up = (int) (1e9);
                    int left = (int) (1e9);
                    if(j>0){
                        up =  grid[i][j] + dp[i][j-1];
                    }
                    if(i>0){
                        left =  grid[i][j] + dp[i-1][j];
                    }
                    dp[i][j] = Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }

    private static int top_down_helper(int i, int j, int[][] grid, int[][] dp) {
        if(i==0 && j==0){
            return grid[0][0];
        }
        if(i<0 || j<0){
            return (int) (1e9);
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int up = top_down_helper(i,j-1,grid,dp) + grid[i][j];
        int left = top_down_helper(i-1,j,grid,dp) + grid[i][j];

        dp[i][j] = Math.min(up,left);
        return dp[i][j];
    }

    private static int helper(int i,int j, int [][] grid){
        if(i==0 && j==0){
            return grid[0][0];
        }
        if(i<0 || j<0){
            return (int) (1e9);
        }

        int up = helper(i,j-1,grid) + grid[i][j];
        int left = helper(i-1,j,grid) + grid[i][j];

        return Math.min(up,left);
    }
}
