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

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        helper_bottom_up(n-1, 3,points,dp);
    }

    private static int helper_bottom_up(int day, int last, int[][] points, int[][] dp) {
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][3] = Math.max(points[0][0],Math.max(points[0][2],points[0][1]));

        for(int i=1;i<=day;i++){
            for(int j=0;j<4;j++){
                int maxi = 0;
                for(int task=0;task<3;task++){
                    if(task != j){
                        int point = points[i][task] + dp[i-1][task];
                        maxi=Math.max(maxi,point);
                    }
                }
                dp[i][j] = maxi;
            }
        }
        return dp[day][last];
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
