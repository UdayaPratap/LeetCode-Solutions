/*
Given a string s, return the longest palindromic substring in s.
*/
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0)
            return null;
        if(s.length()==1)
            return s;
        
        String max="";
        for(int i=0;i<s.length();i++){
            String tmp=helper(s,i,i);
            if(tmp.length()>max.length())
                max=tmp;
            tmp=helper(s,i,i+1);
            if(tmp.length()>max.length())
                max=tmp;
        }
        return max;
    }
    static String helper(String s, int left ,int right)
    {
        while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}
