/*
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
*/
class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp=new Boolean[s.length()+1][p.length()+1];
        return helper(s, 0, p, 0, dp);
    }
    boolean helper(String s, int i, String p, int j, Boolean[][] dp)
    {
        int m=s.length(), n=p.length();
        if(j==n) return i==m;
        if(dp[i][j]!=null) return dp[i][j];

        char pChar=p.charAt(j);
        if(j<n-1 && p.charAt(j+1)=='*'){
            return dp[i][j]= helper(s, i, p, j+2, dp) //0 occurence of *character, match with next.
                    || i<m && check(pChar, s.charAt(i)) && helper(s, i+1, p, j, dp); //curr char of s matched with * character.
        }
        return  dp[i][j]=i<m && check(pChar, s.charAt(i)) && helper(s, i+1, p, j+1, dp);
    }
    boolean check(char a, char b)
    {
        if(a=='.') return true;
        return a==b;
    }
}
