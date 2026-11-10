package dp_qns;

public class House_robber_2 {
    static void main(String[] args) {
        int[] a = {7, 3, 2, 8, 2, 1, 10};
        int n = a.length;
        System.out.println(fill(a, n));
        ;
        System.out.println(fill_space_optimized(a, n));
        ;
    }

    public static int fill_space_optimized(int[] a, int n) {
        if(n==1){
            return a[0];
        }
        int[] t1 = new int[n - 1];
        int[] t2 = new int[n - 1];

        for (int i = 0; i < n-1; i++) {
            t1[i] = a[i + 1];
            t2[i] = a[i];
        }

        return Math.max(bottom_up_space_optimized(t1, t1.length-1), bottom_up_space_optimized(t2, t2.length-1));

    }

    public static int fill(int[] a, int n) {
        if (n == 1) {
            return a[0];
        }
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];

        int[] t1 = new int[n - 1];
        int[] t2 = new int[n - 1];

        for (int i = 0; i < n-1; i++) {
            t1[i] = a[i + 1];
            t2[i] = a[i];
        }

        return Math.max(bottom_up(t1, t1.length-1, dp1), bottom_up(t2, t2.length-1, dp2));

    }

    public static int bottom_up(int[] a, int n, int[] dp) {
        for (int i = 0; i <= n; i++) {
            int take = a[i] + (i >= 2 ? dp[i - 2] : 0);
            int skip = (i >= 1 ? dp[i - 1] : 0);
            dp[i] = Math.max(take, skip);
        }
        return dp[n];
    }

    public static int bottom_up_space_optimized(int[] a, int n) {
        int prev2 = 0;
        int prev1 = a[0];
        for (int i = 1; i <= n; i++) {
            int take = a[i] + prev2;
            int skip = prev1;

            int curr = Math.max(take, skip);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}


