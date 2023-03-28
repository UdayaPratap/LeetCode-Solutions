/*
You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
*/
class Solution {
    int max;
    public int maxLength(List<String> arr) {
        max=-2;
        helper(arr, "", 0);
        return max;
    }
    void helper(List<String> arr, String curr, int idx){
       if(max<curr.length()){
           max=curr.length();
           System.out.println(curr);
       }
       if(idx==arr.size()) return;
        if(valid(curr+arr.get(idx))) helper(arr, curr+arr.get(idx), idx+1);
        helper(arr, curr, idx+1);
    }
    boolean valid(String s)
    {
        int[] f=new int[26];
        for(int i=0; i<s.length(); i++)
        {
            if(++f[s.charAt(i)-'a']==2) return false;
        }
        return true;
    }
}
