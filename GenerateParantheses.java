/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
 class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
         helper(ans, "", 0, 0, n);
         return ans;
    }
    void helper(List<String> ans, String s, int open, int close, int n)
    {
        if(s.length()==2*n)//good string made
        {
            ans.add(s);
            return;
        }

        if(open<n)
            helper(ans, s+"(", open+1, close, n);
        if(close<open) //closed cannot be more than opened brackets
            helper(ans, s+")", open, close+1, n);
    }
}
