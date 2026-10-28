//package dp_qns;
//
//public class qns_0_1_knapsack {
//    static void main(String[] args) {
//        int []p={10,20,30};
//        int []wt={1,1,1};
//        int wt_cap=2;
//        int n=p.length;
//        int price_obtained=0;
//
//        System.out.println(helper(p,wt,wt_cap,n,price_obtained));
//    }
//    public static int helper(int[] p, int[]wt, int wt_cap, int n, int price_obtained){
//        if(wt_cap==0||n==0){
//            return price_obtained;
//        }
//        if(wt[n-1]>wt_cap){
//            return helper(p,wt,wt_cap,n-1, price_obtained);
//        }
//        return Math.max(helper(p,wt,wt_cap,n-1, price_obtained),helper(p,wt,wt_cap-wt[n-1],n-1, price_obtained+p[n-1]));
//    }
//}


package dp_qns;

public class qns_0_1_knapsack {
    static void main(String[] args) {
        int []p={10,20,30};
        int []wt={1,1,1};
        int wt_cap=2;
        int n=p.length;
        int price_obtained=0;

        int [][]dp=new int[n+1][wt_cap+1];

        System.out.println(helper(p,wt,wt_cap,n,price_obtained,dp));
    }
    public static int helper(int[] p, int[]wt, int wt_cap, int n, int price_obtained, int[][] dp){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=wt_cap;j++){
                if(wt[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(p[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
            }
        }
        return dp[n][wt_cap];
    }
}
