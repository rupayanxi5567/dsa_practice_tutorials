package dp_qns;

import java.util.*;

public class Ninja_Practice {
    static void main(String[] args) {
        int n=4;
        int[][] points = {
                {3,4,5},
                {4,6,8},
                {5,6,7},
                {1,7,8}
        };

        int [][]dp = new int[n][4];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        helper(n-1, 3,points,dp);
    }
    public static int helper(int day, int last, int[][] points, int[][] dp){
        if(day == 0){
            int maxi=0;
            for(int task = 0; task <=2; task++){
                if(task !=last){
                    maxi=Math.max(maxi,points[0][task]);
                }
            }
            return maxi;
        }

        if(dp[day][last] != -1){
            return dp[day][last];
        }

        int maxi = 0;
        for(int task=0;task<=2;task++){
            if(task!=last){
                int point = points[day][task] + helper(day-1,task,points, dp);
                maxi=Math.max(maxi,point);
            }
        }
        dp[day][last]=maxi;
        return dp[day][last];
    }
}
