package dp_qns;

import java.util.Arrays;

public class no_of_hops {
    static void main(String[] args) {
        int n = 5;
        int []dp=new int [n+1];
        System.out.println(helper(0,n));
        Arrays.fill(dp,0);
        System.out.println(top_downs(n,dp));
        Arrays.fill(dp,0);
        System.out.println(bottom_ups(n,dp));
        System.out.println(bottom_ups_space_optimized(n));
    }

    private static int bottom_ups_space_optimized(int n) {

        if(n==1||n==0){
            return 1;
        }

        if(n==2){
            return 2;
        }

        int a=1;
        int b=1;
        int c=2;
        for(int i=3;i<=n;i++){
            int next=a+b+c;
            a=b;
            b=c;
            c=next;
        }
        return c;
    }

    private static int bottom_ups(int n, int[] dp) {
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }

        dp[1]=1;

        if(n>=2){
            dp[2]=2;
        }
        if(n>=3){
            dp[3]=4;
        }

        for(int i=4;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }

        return dp[n];
    }

    private static int top_downs(int n, int[] dp) {
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]=top_downs(n-1,dp)+top_downs(n-2,dp)+top_downs(n-3,dp);
        return dp[n];
    }

    public static int helper(int i,int n){
        if(i==n){
            return 1;
        }
        if(i>n){
            return 0;
        }
        return helper(i+1,n)+helper(2+i,n)+helper(3+i,n);
    }
}
