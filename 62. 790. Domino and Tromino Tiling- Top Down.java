class Solution {
    //Dervied Formula 
    //f(n)=2*f(n-1)+f(n-3)
    //Dp- TOp Down Approach
    int mod=1000000007;
    int dp[]=new int[1001];
    public int numTilings(int n) {
        Arrays.fill(dp,-1);
        return solve(n);
    }

    private int solve(int n){
        if(n==1||n==2){
            return n;
        }
        if(n==3){
            return 5;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=(2*solve(n-1)%mod+solve(n-3)%mod)%mod;
    }
}
