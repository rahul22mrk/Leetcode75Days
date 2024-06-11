class Solution {
    //DP: Top Down (Rec+Memo)
    int dp[][]=new int[101][101];
    public int uniquePaths(int m, int n) {
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,m,n);//start traverse from top left corner as mentioned in ques
    }

    private int solve(int i,int j,int m,int n){
        //if i and j is in invalid position then we will return 0
        if(i<0||i>=m||j<0||j>=n){
            return 0;
        }

        //if i and j reach to bottom right corner then we will return 1
        if(i==m-1 && j==n-1){
            return 1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];//already solved for that i and j
        }

        //now we can go either right -> solve(i,j+1,m,n) 
        //or down ->solve(i+1,j,m,n);
        return dp[i][j]=solve(i,j+1,m,n)+solve(i+1,j,m,n);
    }
}
