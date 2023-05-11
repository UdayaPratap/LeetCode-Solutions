/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).
*/
class Solution {
    public boolean isMatch(String s, String p) {
        dp=new Boolean[s.length()][p.length()];
        return helper(s, 0, p, 0);
    }
    Boolean dp[][];
    boolean helper(String s, int i, String p, int j){
        //conditions for when i==s.length
        if(i==s.length() && j==p.length()) return true;
        if(i == s.length()){
            for(int index = j;index<p.length();index++){
                if(p.charAt(index)!='*'){
                    return false;
                }
            }
            return true;
        }
        //when j==p.length and i!=s.length
        if(j == p.length())return false;
        if(dp[i][j]!=null) return dp[i][j];
        if(p.charAt(j)=='?'){

             return dp[i][j]=helper(s, i+1, p, j+1);
        }

        if(p.charAt(j)=='*'){
            //*==empty
            if(helper(s, i, p, j+1)) return dp[i][j]=true;
            //*==multiple characters, hence move in s but still keep *
            if(helper(s, i+1, p ,j)) return dp[i][j]=true;
            //*==single character
            if(helper(s, i+1, p, j+1)) return dp[i][j]=true;

        }

        return dp[i][j]=s.charAt(i)==p.charAt(j) && helper(s, i+1, p, j+1);
    }
}
