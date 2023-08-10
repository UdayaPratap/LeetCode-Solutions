/*
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
  */
class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] memo=new Boolean[s.length()+1][s.length()+1];
        return helper(s.toCharArray(), 0, 0, memo);
    }
    boolean helper(char[] arr, int i, int open, Boolean[][] memo){
        if(i==arr.length){
            return open==0;
        }
        if(open<0 || open>arr.length/2) return false;
        if(memo[i][open]!=null) return memo[i][open];
        if(arr[i]=='(') return memo[i][open]=helper(arr, i+1, open+1, memo);
        if(arr[i]==')') return memo[i][open]=helper(arr, i+1, open-1, memo);

        //if *
        
        // consider empty string
        if(helper(arr, i+1, open, memo)) return memo[i][open]=true;
        //consider (
        if(helper(arr, i+1, open+1, memo)) return memo[i][open]=true;
        //consider )
        if(helper(arr, i+1, open-1, memo)) return memo[i][open]=true;
        return memo[i][open]=false;
    }
}
