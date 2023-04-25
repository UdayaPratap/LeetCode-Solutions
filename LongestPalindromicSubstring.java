/*
Given a string s, return the longest 
palindromic
 
substring
 in s.
 */
class Solution {
    int start;
    int maxLen;
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==1) return s;
        String max="";
        for(int i=0; i<n-1; i++)
        {
            check(s, i, i);
            check(s, i, i+1);
        }
        return max=s.substring(start, start+maxLen-1);
    }
    void check(String s, int left, int right){
        if(s.charAt(left)!=s.charAt(right)) return;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;

        }
        if(right-left+1>maxLen){
            start=left+1;
            maxLen=right-left;
        }
        return;
    }
}
