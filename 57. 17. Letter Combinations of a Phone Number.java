class Solution {
    HashMap<Character,String>hm;
    List<String>ans;
    public List<String> letterCombinations(String digits) {
        ans=new ArrayList<>();
        if(digits==null|| digits.length()==0){
            return ans;
        }
        //initalize map and mapped the char and connected string
        hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        solve(digits,0,new StringBuilder());
        return ans;
        
    }

    private void solve(String digits,int index,StringBuilder sb){
        if(index>=digits.length()){
            ans.add(sb.toString());
            return ;
        }
        String connectedLetters = hm.get(digits.charAt(index));
        for(int i=0;i<connectedLetters.length();i++){
            char ch = connectedLetters.charAt(i);
            //add this to our temp ans -sb
            sb.append(ch);
            //traverse for the next char of index
            solve(digits,index+1,sb);
            //now remove the appended char from sb
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
