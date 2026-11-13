package dp_qns;

public class Grid_Unique_Path_2 {
    static void main(String[] args) {
        int [][] matrix = {
                {0,0,0,0},
                {0,0,-1,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        int m = matrix.length;;
        int n = matrix[0].length;

        int endI=m-1;
        int endJ=n-1;

        helper(endI,endJ,matrix);

        bottom_up(endI,endJ,matrix);
    }
    public static int helper(int endI,int endJ,int [][]matrix){
        if(endI>=0 && endJ>=0 && matrix[endI][endJ]==-1){
            return 0;
        }
        if(0==endI && 0==endJ){
            return 1;
        }
        if(endI < 0 || endJ < 0){
            return 0;
        }
        int left = helper(endI-1,endJ,matrix);
        int up = helper(endI,endJ-1,matrix);

        return left+up;
    }

    public static int bottom_up(int endI,int endJ,int [][]matrix){
        int [][] dp = new int[endI+1][endJ+1];

        for(int i=0;i<=endI;i++){
            for(int j=0;j<=endJ;j++){

                if(matrix[i][j]==-1){
                    dp[i][j]=0;
                }else{
                    if(i==0 && j==0){
                        dp[0][0]=1;
                    }else{
                        int left=0;
                        int up=0;
                        if(i>0){
                            left = dp[i-1][j];
                        }
                        if(j>0){
                            up = dp[i][j-1];
                        }
                        dp[i][j] = left+up;
                    }
                }

            }
        }
        return dp[endI][endJ];
    }
}
