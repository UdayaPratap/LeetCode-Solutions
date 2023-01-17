/*
Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
. Return all possible palindrome partitioning of s.
*/
class Solution {
    public List<List<String>> partition(String s) {
        int[][] dp=new int[s.length()+1][s.length()+1];
        for(int[] t:dp)
            Arrays.fill(t,-1);
        List<List<String>> ans=new ArrayList<>();
        helper(s, 0, ans, new ArrayList<String>(), dp);
        return ans;
    }
    void helper(String s, int start, List<List<String>> ans, ArrayList<String> list, int[][] dp)
    {
        if(start==s.length())
        {
            ans.add(new ArrayList<String>(list));
            return;
        }
        for(int i=start;i<s.length();i++)
        {
            if(isPal(s,start,i,dp))
            {
                list.add(s.substring(start,i+1));
                helper(s,i+1,ans,list, dp);
                list.remove(list.size()-1);
            }
            
        }
        return;
    }
    boolean isPal(String s, int start, int end,int [][] dp)
    {
        if(dp[start][end]!=-1)
        {
            if(dp[start][end]==1)
                return true;
            return false;
        }
        while(start<end)
        {
            if(s.charAt(start) != s.charAt(end))
            {
                dp[start][end]=0;
                return false;
            }
            start++;
            end--;
        }
        dp[start][end]=1;
        return true;
    }
}
