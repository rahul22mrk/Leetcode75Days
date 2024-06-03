class Solution {
    int dp[]=new int[101];
    public int rob(int[] nums) {
        Arrays.fill(dp,-1);
        return solve(nums,0,nums.length);
        
    }

    private int solve(int[] nums,int i,int n){
        if(i>=n){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int steal = nums[i]+solve(nums,i+2,n);
        int skip = solve(nums,i+1,n);
        return dp[i]=Math.max(steal,skip);
    }
}
