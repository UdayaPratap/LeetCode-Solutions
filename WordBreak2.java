/*
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
*/
class Solution {
    List<String> ans;
    public void helper(String s, int left, Set<String> dict, List<String> curr){
        for(int i=left+1;i<=s.length();i++){
            String f = s.substring(left, i);
            if(dict.contains(f)){
                curr.add(f);
                if(i==s.length()){
                    String[] stringparts = curr.toArray(new String[0]);
                    ans.add(String.join(" ", stringparts));
                }    
                else helper(s, i, dict, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<String>();
        Set<String> dict = new HashSet();
        for(String w:wordDict) dict.add(w);
        helper(s, 0, dict, new ArrayList<String>());
        return ans;
    }
}
