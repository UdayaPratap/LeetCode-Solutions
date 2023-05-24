/*
Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
*/
class Solution {
    Map<String,Boolean> map;
    public int numMatchingSubseq(String s, String[] words) {
        map = new HashMap<>();
        int count = 0;
        for(String w:words){
            if(helper(s,w)) count++;
        }
        return count;
    }
    
    private boolean  helper(String a, String b){
        int p1 = 0;
        int p2 = 0;
        int n = a.length();
        int m = b.length();
        if(map.containsKey(b)) return map.get(b);
         
        while(p1<n){
            if(a.charAt(p1)==b.charAt(p2)){
                p1++;
                p2++;
            }else{
                p1++;
            }
            if(p2==m && p1<=n){
                map.put(b,true);
                return true;
            }
        }
        map.put(b,false);
        return false;
       
    }
}
