package dp_qns;

import java.util.Arrays;

public class Frog_Jump {
    static void main(String[] args) {
        int []a = {30,10,60,10,60,50};
        int i=0;
        int n=a.length;

        int []dp=new int[n+1];
        System.out.println(helper(i,n-1,a));;

        Arrays.fill(dp,-1);
        System.out.println(top_down(i,n-1,a,dp));;

        System.out.println(bottom_up(a));;

        System.out.println(bottom_up_space_optimized(a,n));;
    }

    private static int bottom_up_space_optimized(int[] a,int n) {
        int prev2=0;
        int prev=Math.abs(a[1]-a[0]);

        if(n==2){
            return prev;
        }

        for(int i=2;i<n;i++){
            int one = prev + Math.abs(a[i-1]-a[i]);
            int two = prev2 + Math.abs(a[i]-a[i-2]);
            int curr = Math.min(one,two);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }

    public static int bottom_up(int[] a){
        int n=a.length;
        int []dp=new int[n];

        if(1==n){
            return 0;
        }

        dp[0]=0;
        dp[1]=Math.abs(a[1]-a[0]);

        for(int k=2;k<n;k++){
            int one = dp[k-1] + Math.abs(a[k]-a[k-1]);
            int two = dp[k-2] + Math.abs(a[k]-a[k-2]);

            dp[k] = Math.min(one,two);
        }

        return dp[n-1];
    }

    public static int top_down(int i, int n, int[] a, int[] dp){
        if(i==n){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int one = Math.abs(a[i]-a[i+1]) + top_down(i+1,n,a,dp);
        int two = Integer.MAX_VALUE;

        if(i+2 <= n){
            two = Math.abs(a[i]-a[i+2]) + top_down(i+2,n,a,dp);
        }

        dp[i] = Math.min(one , two);
        return dp[i];
    }

    public static int helper(int i,int n,int[] a){
        if(i==n){
            return 0;
        }

        int one = Math.abs(a[i]-a[i+1]) + helper(i+1,n,a);
        int two = Integer.MAX_VALUE;

        if(i+2 <= n){
            two = Math.abs(a[i]-a[i+2]) + helper(i+2,n,a);
        }

        return Math.min(one , two);
    }
}
