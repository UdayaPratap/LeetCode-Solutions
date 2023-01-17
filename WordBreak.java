/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
*/
class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        if(dict.contains(s))
            return true;
     boolean[] dp=new boolean[s.length()]; //dp[i] denotes if dict contains substring(0,i) whether as a whole or in words or not
     for(int i=0;i<s.length();i++)
     {
        if(dict.contains(s.substring(0,i)))
            dp[i]=true;
        else
            for(int j=i;j>=0;j--)
            {
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        if(dp[i] && dict.contains(s.substring(i,s.length())))
            return true;
     }
        return false;
    }
}
