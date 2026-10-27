package dp_qns;

public class longest_common_subsequences {
    static void main() {
        String x="a";
        String y="a";

        int m=x.length();
        int n=y.length();

        int [][]dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }

        for(int j=0;j<=m;j++){
            dp[j][0]=0;
        }

        System.out.println(helper(x,y,m,n,dp));

        long start = System.nanoTime();
        long end = System.nanoTime();
        System.out.println((end - start) / 1_000_000.0 + " ms");
    }
    public static int helper(String x,String y,int m,int n,int [][]dp){
        if(m==0 || n==0){
            return 0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
