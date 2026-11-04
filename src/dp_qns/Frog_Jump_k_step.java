package dp_qns;

import java.util.Arrays;

public class Frog_Jump_k_step {
    static void main(String[] args) {
        int []a = {30,10,60,10,60,50};
        int i=0;
        int n=a.length;

        System.out.println(bottom_up(a,4));;
    }

    public static int bottom_up(int[] a,int k){
        int n=a.length;
        int []dp=new int[n];

        if(1==n){
            return 0;
        }

        dp[0]=0;
        dp[1]=Math.abs(a[1]-a[0]);

        for(int i=1;i<n;i++){
            int minStep = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int jumpEnergy = dp[i-j] + Math.abs(a[i] - a[i-j]);
                    minStep = Math.min(minStep,jumpEnergy);
                }
            }
            dp[i] = minStep;
        }
        return dp[n-1];
    }
}
