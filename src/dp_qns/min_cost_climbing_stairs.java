package dp_qns;

import java.util.*;

public class min_cost_climbing_stairs {
    static void main(String[] args) {
        int[] a = {10, 15, 20};
        int n = a.length;
        System.out.println(helper(a, n));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(top_down(a, n, dp));

        Arrays.fill(dp, -1);
        System.out.println(bottom_upp(a, n, dp));

        System.out.println(bottom_upp_space_optimized(a, n, dp));
    }

    private static int bottom_upp_space_optimized(int[] a, int n, int[] dp) {

        if (n <= 1) {
            return 0;
        }

        int prev=0;
        int curr=0;

        for(int i=2;i<=n;i++){
            int next=Math.min(a[i-2]+prev,curr+a[i-1]);
            prev=curr;
            curr=next;
        }
        return curr;
    }

    private static int bottom_upp(int[] a, int n, int[] dp) {
        if (n <= 1) {
            return 0;
        }
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1]+a[i-1],dp[i-2]+a[i-2]);
        }
        return dp[n];
    }

    public static int helper(int[] a, int n) {
        if (n <= 1) {
            return 0;
        }
        return Math.min(a[n - 1] + helper(a, n - 1), a[n - 2] + helper(a, n - 2));
    }

    public static int top_down(int[] a, int n, int[] dp) {
        if (n <= 1) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = Math.min(a[n - 1] + top_down(a, n - 1, dp), a[n - 2] + top_down(a, n - 2, dp));
    }

}
