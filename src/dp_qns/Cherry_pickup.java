package dp_qns;

public class Cherry_pickup {
    static void main() {
        int [][]a={
                {1,2,3,24},
                {1,2,34,4},
                {1,2,33,4},
                {1,2,3,34}
        };

        int m=a.length;
        int n=a[0].length;

        int i=0;
        int j1=0;
        int j2=n-1;

        System.out.println(helper_cherry_pickup(i,j1,j2,a,m,n));

        int [][][] dp=new int[m][n][n];
        System.out.println(top_down_cherry_pickup(i,j1,j2,a,m,n,dp));

        System.out.println(bottom_up_cherry_pickup(a,m,n));

    }

    private static int bottom_up_cherry_pickup(int[][] a, int m, int n) {
        int [][][] dp=new int[m][n][n];

        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2) {
                    dp[m - 1][j1][j2] = a[m - 1][j1];
                } else {
                    dp[m - 1][j1][j2] = a[m - 1][j1] + a[m - 1][j2];
                }
            }
        }

        for(int i=m-2;i>=0;i--){
            for(int j1=0;j1<n;j1++){
                for(int j2=0;j2<n;j2++){
                    int mx = -1;

                    for(int dj1=-1; dj1<=1; dj1++){
                        for(int dj2=-1; dj2<=1; dj2++){
                            int nj1 = j1 + dj1;
                            int nj2 = j2 + dj2;

                            if (nj1 >= 0 && nj1 < n && nj2 >= 0 && nj2 < n) {
                                int val = (j1 == j2) ? a[i][j1] : (a[i][j1] + a[i][j2]);
                                val += dp[i + 1][nj1][nj2];
                                mx = Math.max(mx, val);
                            }
                        }
                    }
                    dp[i][j1][j2]=mx;
                }
            }
        }
        return dp[0][0][n-1];
    }

    private static int top_down_cherry_pickup(int i, int j1, int j2, int[][] a, int m, int n, int[][][] dp) {
        if(j1<0 || j2<0 || j1>=n || j2>=n){
            return -18;
        }
        if(i==m-1){
            if(j1==j2){
                return a[i][j1];
            }else{
                return a[i][j1]+a[i][j2];
            }
        }

        if(dp[i][j1][j2] != 0){
            return dp[i][j1][j2];
        }

        int mx = -1;

        for(int dj1=-1; dj1<=1; dj1++){
            for(int dj2=-1; dj2<=1; dj2++){
                if(j1==j2){
                    mx=Math.max(mx,a[i][j1]+top_down_cherry_pickup(i+1,j1+dj1,j2+dj2,a,m,n,dp));
                }else{
                    mx=Math.max(mx,a[i][j1]+a[i][j2]+top_down_cherry_pickup(i+1,j1+dj1,j2+dj2,a,m,n,dp));
                }
            }
        }
        dp[i][j1][j2]=mx;
        return dp[i][j1][j2];
    }

    private static int helper_cherry_pickup(int i, int j1, int j2, int[][] a, int m, int n) {
        if(j1<0 || j2<0 || j1>=n || j2>=n){
            return -18;
        }
        if(i==m-1){
            if(j1==j2){
                return a[i][j1];
            }else{
                return a[i][j1]+a[i][j2];
            }
        }

        int mx = -1;

        for(int dj1=-1; dj1<=1; dj1++){
            for(int dj2=-1; dj2<=1; dj2++){
                if(j1==j2){
                    mx=Math.max(mx,a[i][j1]+helper_cherry_pickup(i+1,j1+dj1,j2+dj2,a,m,n));
                }else{
                    mx=Math.max(mx,a[i][j1]+a[i][j2]+helper_cherry_pickup(i+1,j1+dj1,j2+dj2,a,m,n));
                }
            }
        }
        return mx;
    }
}
