package dp_qns;

public class House_robber_1 {
    static void main(String[] args) {
        int[]a={7,3,2,8,2,1,10};
        int n=a.length;
        int []dp=new int[n+1];
        System.out.println(helper(a,n-1));;
        System.out.println(top_down(a,n-1,dp));;
        System.out.println(bottom_up(a,n-1,dp));;
    }

    public static int bottom_up(int[] a,int n, int[]dp){
        for(int i=0;i<=n;i++){
            int take = a[i] + (i>=2 ? dp[i-2] : 0);
            int skip = (i>=1 ? dp[i-1] : 0);
            dp[i] = Math.max(take,skip);
        }
        return dp[n];
    }

    public static int top_down(int[] a,int n, int[]dp){
        if(n<0){
            return 0;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        dp[n]=Math.max(a[n]+top_down(a,n-2,dp),top_down(a,n-1,dp));
        return dp[n];
    }

    public static int helper(int[] a,int n){
        if(n<0){
            return 0;
        }
        return Math.max(a[n]+helper(a,n-2),helper(a,n-1));
    }
}
