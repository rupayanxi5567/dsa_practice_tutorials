package dp_qns;

import java.util.Arrays;

public class SubsetSumEqualsToTarget {
    static void main(String[] args) {
        int []a={2,3,3,3,4,5};
        int n = a.length;
        int sum=0;
        int i=0;

        int tepSum=0;
        for(int x:a){
            tepSum+=x;
        }
        int target = tepSum / 2;
        if(tepSum%2==0){
            System.out.println(helperSubsetSumEqualsToTarget(a,target,n,sum,i));

            int[][] dp = new int[n][target + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            System.out.println(topDownSubsetSum(a, target, n, sum, i, dp));

            System.out.println(bottomUpSubsetSum(a, target, n));
        }
    }

    private static boolean bottomUpSubsetSum(int[] a, int k, int n) {
        int[][] dp = new int[n][k + 1];

        for (int ind = 0; ind < n; ind++) {
            dp[ind][0] = 1;
        }

        if (a[0] <= k) {
            dp[0][a[0]] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                int notPick = dp[ind - 1][target];
                int pick = 0;

                if (a[ind] <= target) {
                    pick = dp[ind - 1][target - a[ind]];
                }

                dp[ind][target] = (notPick == 1 || pick == 1) ? 1 : 0;
            }
        }

        return dp[n - 1][k] == 1;
    }

    private static boolean topDownSubsetSum(int[] a, int k, int n, int sum, int i, int[][] dp) {
        if(sum==k){
            return true;
        }

        if(i==n || sum>k){
            return false;
        }

        if(dp[i][sum] != -1){
            return dp[i][sum]==1;
        }

        boolean pick = false;
        if(sum+a[i] <= k){
            pick=topDownSubsetSum(a,k,n,sum+a[i],i+1,dp);
        }

        boolean notpick = topDownSubsetSum(a,k,n,sum,i+1,dp);

        boolean ans = pick || notpick;

        dp[i][sum] = ans ? 1 : 0;
        return ans;
    }

    private static boolean helperSubsetSumEqualsToTarget(int[] a, int k, int n, int sum, int i) {
        if(sum==k){
            return true;
        }

        if(i==n){
            return false;
        }

        sum+=a[i];
        if(helperSubsetSumEqualsToTarget(a,k,n,sum,i+1)){
            return true;
        }
        sum-=a[i];
        if(helperSubsetSumEqualsToTarget(a,k,n,sum,i+1)){
            return true;
        }

        return false;
    }
}
