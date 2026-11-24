package dp_qns;

public class Maximum_Falling_Path_Sum {
    static void main(String[] args) {
        int [][] a = {
                {1,2,10,4},
                {100,3,2,1},
                {1,1,20,2},
                {1,2,2,1},
        };

        int m = a.length;
        int n = a[0].length;

        int mx=-1;
        for(int j=0;j<n;j++){
            mx = Math.max(mx,helper(0,j,m,n,a));
        }
        System.out.println(mx);

        int mx1=-1;
        int [][] dp = new int[m][n];
        for(int j=0;j<n;j++){
            mx1 = Math.max(mx1,top_down(0,j,m,n,a,dp));
        }
        System.out.println(mx1);

        int mx2=-1;
        int [][] dp1 = new int[m][n];
        for(int j=0;j<n;j++){
            mx2 = Math.max(mx2,bottom_up(m,n,a,dp1));
        }
        System.out.println(mx2);
    }

    public static int bottom_up(int m, int n, int[][]a, int[][] dp){
        for(int col=0;col<n;col++){
            dp[m-1][col] = a[m-1][col];
        }
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int leftDiagonal = -1;
                int rightDiagonal = -1;

                if(j>=1){
                    leftDiagonal = a[i][j] + dp[i+1][j-1];
                }
                if(j<n-1){
                    rightDiagonal= a[i][j] + dp[i+1][j+1];
                }
                int down = a[i][j] + dp[i+1][j];

                dp[i][j] = Math.max(down,Math.max(leftDiagonal,rightDiagonal));
            }
        }
        int mx = Integer.MIN_VALUE;
        for(int j = 0; j < n; j++){
            mx = Math.max(mx, dp[0][j]);
        }
        return mx;
    }

    public static int top_down(int i, int j, int m, int n, int[][]a, int[][] dp){
        if(i==m-1){
            return a[i][j];
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int leftDiagonal = 0;
        int rightDiagonal = 0;
        if(j>=1){
            leftDiagonal = a[i][j] + top_down(i+1,j-1,m,n,a,dp);
        }
        if(j<n-1){
            rightDiagonal= a[i][j] + top_down(i+1,j+1,m,n,a,dp);
        }
        int down = a[i][j] + top_down(i+1,j,m,n,a,dp);

        dp[i][j] = Math.max(down,Math.max(leftDiagonal,rightDiagonal));
        return dp[i][j];
    }

    public static int helper(int i,int j,int m,int n,int[][]a){
        if(i==m-1){
            return a[i][j];
        }

        int leftDiagonal = 0;
        int rightDiagonal = 0;
        if(j>=1){
            leftDiagonal = a[i][j] + helper(i+1,j-1,m,n,a);
        }
        if(j<n-1){
            rightDiagonal= a[i][j] + helper(i+1,j+1,m,n,a);
        }
        int down = a[i][j] + helper(i+1,j,m,n,a);

        return Math.max(down,Math.max(leftDiagonal,rightDiagonal));
    }

}
