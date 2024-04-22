class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(k,n,ans,new ArrayList<>(),1);
        return ans;
    }

    private void solve(int k,int n,List<List<Integer>>ans,List<Integer>curr,int start){
        if(n==0 && curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<=9;i++){
            if(!curr.contains(i) && i<=n){
                //add the i to curr list
                curr.add(i);
                //explore now 
                solve(k,n-i,ans,curr,i+1);
                //remove i from the curr list
                curr.remove(curr.size()-1);
            }
        }
    }
}
