package dp_qns;

public class climbing_stairs {
    public static void main(String[] args) {
        int n = 5;
        long[] dp = new long[n + 1];

        System.out.println(helper(n));
        System.out.println(rohit_helper(0,n));
        System.out.println(top_down(dp,n));
        System.out.println(bottom_up(dp,n));
        System.out.println(space_optimized_bottom_up(dp,n));
    }

    private static long space_optimized_bottom_up(long[] dp, int n) {
        if(n<=2){
            return n;
        }
        long prev=1;
        long curr=2;
        for(int i=3;i<=n;i++){
            long next = prev+curr;
            prev=curr;
            curr=next;
        }
        return curr;
    }

    private static long bottom_up(long[] dp, int n) {
        if(n<=2){
            return n;
        }
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    private static long top_down(long[] dp, int n) {
        if(n<=2){
            return n;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        dp[n] = top_down(dp,n-1)+top_down(dp,n-2);
        return dp[n];
    }

    public static int helper(int n){
        if(n<=2){
            return n;
        }
        return helper(n-1)+helper(n-2);
    }

    public static int rohit_helper(int i,int n){
        if(n==i){
            return 1;
        }
        if(i>n){
            return 0;
        }
        return rohit_helper(i+1,n)+rohit_helper(i+2,n);
    }
}
