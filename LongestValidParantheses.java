/*
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
substring
.
*/
class Solution {
    public int longestValidParentheses(String s) {
        int maxLen=0;
        int len=0;
        int st=0;
        int n=s.length();
        //ITERATE FROM FIRST TO LAST
                for(int i=0;i<n;i++)
                {
                    if(s.charAt(i)=='(')
                    {
                        st++;
                        len++;
                    }
                    if(s.charAt(i)==')')
                    {
                        if(st==0)
                        {
                            len=0;
                        }
                        else{
                            st--;
                            len++;
                        }
                    }
                    if(maxLen<len && st==0)
                        maxLen=len;
                }
        len=0;
        st=0;
        //ITERATE FROM LAST TO FIRST
        for(int i=n-1;i>=0;i--)
        {
            if(s.charAt(i)==')')
            {
                st++;
                len++;
            }
            if(s.charAt(i)=='(')
            {
                if(st==0)
                {
                    len=0;
                }
                else{
                    st--;
                    len++;
                }
            }
            if(maxLen<len && st==0)
                maxLen=len;
        }
        
        return maxLen;
    }
}
