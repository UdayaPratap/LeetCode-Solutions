/* Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "". */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans=strs[0];
        int n=ans.length();

        int N=strs.length;
        for(int i=1;i<N;i++)
        {
            n=Math.min(n,strs[i].length());
            while(!strs[i].substring(0,n).equals(ans.substring(0,n)))
                n--;
            if(n==0)
            {
                ans="";
                break;
            }
            ans=ans.substring(0,n);
        }
        return ans;
    }
}
