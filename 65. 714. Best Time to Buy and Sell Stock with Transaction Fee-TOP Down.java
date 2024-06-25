class Solution {
    int dp[][]=new int[50001][2];//recursion+memo
    public int maxProfit(int[] prices, int fee) {
        //intialize dp values with -1
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        //calling a solve method which will solve the prob
        return solve(prices,fee,0,prices.length,1);
    }

    private int solve(int[] prices,int fee,int currDay,int n,int buy){
        //if currDay is > total days then we will simply return 0
        if(currDay>=n){
            return 0;
        }

        //if subproblem already solved then we will return dp values for particular sub problem
        if(dp[currDay][buy]!=-1){
            return dp[currDay][buy];
        }
        int profit =0;
        //condition for buying
        if(buy==1){
            //now we will buy the stock so next day we will either sale or not so "buy=0" and
            // we buy at todayPrice so, - prices[currDay]
            int bought = solve(prices,fee,currDay+1,n,0)-prices[currDay];
            //if not buy 
            int notBuy = solve(prices,fee,currDay+1,n,1);//buy status=1 means next day we will buy

            //calculate max profit
            profit = Math.max(profit,Math.max(bought,notBuy));
        }
        //condition for selling
        else{
            //now we will sale so next day we will buy -> buy status=1 and today 
            //we saling so -> +prices[currDay] -fee (transaction fee)
            int sale = solve(prices,fee,currDay+1,n,1)+prices[currDay]-fee;
            //if not sale ,next day we will sale so buy =0
            int notSale  = solve(prices,fee,currDay+1,n,0);

            //profit 
            profit = Math.max(profit,Math.max(sale,notSale));
        }
        return dp[currDay][buy]=profit;
    }
}
