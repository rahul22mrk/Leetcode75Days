class Solution {
    public int numTilings(int n) {
        //DP - Bottom Up App
        //Dervied Formula
        //f(n) = 2*f(n-1)+f(n-3)

        int mod=1000000007;
        int dp[]=new int[1001];
        //intilaize 
        dp[1]=1;
        dp[2]=2;
        dp[3]=5;

        //now using formula for n>3
        for(int i=4;i<=n;i++){
            dp[i]=(2*dp[i-1]%mod+dp[i-3]%mod)%mod;
        }
        return dp[n];
        
    }
}
