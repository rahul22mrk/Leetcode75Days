class Solution {
    //top down approach - REC+Memo
    int dp[][]=new int[1001][1001];
    public int longestCommonSubsequence(String text1, String text2) {
        //set dp values to -1
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return solve(text1,text2,0,0);
        
    }

    private int solve(String str1,String str2,int i,int j){
        if(i>=str1.length() || j>=str2.length()){
            return 0;
        }

        //for this part already solved then we just returned the ans
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        //if  char mathed in both string then we just incement i and j value and count increased 1+another part
        if(str1.charAt(i)==str2.charAt(j)){
            return dp[i][j]=1+solve(str1,str2,i+1,j+1);
        }else{
            //solve for left and right part and ans is max of left and right value
            int left = solve(str1,str2,i+1,j);
            int right = solve(str1,str2,i,j+1);
            return dp[i][j]=Math.max(left,right);
        }
    }
}
