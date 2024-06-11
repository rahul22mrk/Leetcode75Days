class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[101][101];

        //set the value for bottom-right corner
        dp[m-1][n-1]=1;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    continue;
                }

                //right side
                if(i<m-1){
                    dp[i][j]+= dp[i+1][j];
                }
                //Right side
                if(j<n-1){
                    dp[i][j]+= dp[i][j+1];
                }
            }
        }
        return dp[0][0];//final answer
    }
}
