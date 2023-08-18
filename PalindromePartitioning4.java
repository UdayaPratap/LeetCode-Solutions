/*
Given a string s, return true if it is possible to split the string s into three non-empty palindromic substrings. Otherwise, return false.​​​​​

A string is said to be palindrome if it the same string when reversed.
  */
class Solution {
    public boolean checkPartitioning(String s) {
        palMemo=new Boolean[s.length()+1][s.length()+1];
        return helper(s, 0, 3, new Boolean[s.length()+1][4]);
    }
    boolean helper(String s, int i, int n, Boolean[][] memo){
        if(memo[i][n]!=null) return memo[i][n];
        if(i==s.length()){
            if(n==0) return memo[i][n]=true;
            return memo[i][n]=false;
        }
        if(n==0) return memo[i][n]=false;
        for(int j=i+1; j<=s.length(); j++){
            if(isPal(s, i, j-1) && helper(s, j, n-1, memo)) return memo[i][n]=true;
        }
        return memo[i][n]=false;
    }
    Boolean palMemo[][];
    boolean isPal(String s, int i, int j){
        if(palMemo[i][j] != null) return palMemo[i][j];
        if(i >= j) return palMemo[i][j] = true; 
        if(s.charAt(i) == s.charAt(j)) return palMemo[i][j] = isPal(s, i+1, j-1);
        else return palMemo[i][j] = false;
    }
}
