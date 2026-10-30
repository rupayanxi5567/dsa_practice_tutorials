package dp_qns;

public class fibonacci {
    public static void main(String[] args) {
        int n = 5;
        long[] fib = new long[n + 1];
        System.out.println(topDown(n, fib));
        System.out.println(bottomUp(n));
        System.out.println(bottomUp_constantSpace(n));
    }

    public static long bottomUp_constantSpace(int n){
        long prev=0;
        long curr=1;
        for(int i=2;i<=n;i++){
            long next = prev+curr;
            prev=curr;
            curr=next;
        }
        return curr;
    }

    public static long bottomUp(int n){
        long []dp=new long[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static long topDown(int n, long[] fib) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (fib[n] != 0) {
            return fib[n];
        }
        fib[n] = topDown(n - 1, fib) + topDown(n - 2, fib);
        return fib[n];
    }
}