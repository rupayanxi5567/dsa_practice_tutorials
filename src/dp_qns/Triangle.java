package dp_qns;

public class Triangle {
    static void main(String[] args) {
        int[][] a = {
                {1},
                {2, 3},
                {2, 3, 4},
                {2, 3, 5, 6}
        };

        int m = a.length;
        int n = a[0].length;

        System.out.println(helper(0, 0, m, n, a));

        int[][] dp = new int[m + 1][n + 1];
        System.out.println(top_down(0, 0, m, n, a, dp));

        int[][] dp1 = new int[m][m];
        System.out.println(bottom_up(m, n, a, dp1));
    }

    public static int bottom_up(int m, int n, int[][] a, int[][] dp) {
        for(int j=0;j<a[m-1].length;j++){
            dp[m-1][j] = a[m-1][j];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j++) {
                int down = a[i][j] + dp[i+1][j];
                int dig = a[i][j] + dp[i+1][j+1];

                dp[i][j] = Math.min(down,dig);
            }
        }
        return dp[0][0];
    }

    public static int helper(int i, int j, int m, int n, int[][] a) {
        if (i == m - 1) {
            return a[m - 1][j];
        }

        int down = a[i][j] + helper(i + 1, j, m, n, a);
        int diagonal = a[i][j] + helper(i + 1, j + 1, m, n, a);

        return Math.min(down, diagonal);
    }

    public static int top_down(int i, int j, int m, int n, int[][] a, int[][] dp) {
        if (i == m - 1) {
            return a[m - 1][j];
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int down = a[i][j] + top_down(i + 1, j, m, n, a, dp);
        int dig = a[i][j] + top_down(i + 1, j + 1, m, n, a, dp);

        dp[i][j] = Math.min(down, dig);
        return dp[i][j];
    }
}
