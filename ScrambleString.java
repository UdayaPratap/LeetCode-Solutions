/*
We can scramble a string s to get a string t using the following algorithm:

If the length of the string is 1, stop.
If the length of the string is > 1, do the following:
Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
Apply step 1 recursively on each of the two substrings x and y.
Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
*/
class Solution {
    Map<String, Boolean> memo;
    public boolean isScramble(String s1, String s2) {
        memo=new HashMap<>();
        return helper(s1, s2);
    }
    boolean helper(String a, String b){
        if(a.equals(b)) return true;
        if(a.length()<=1) return false;

        String key=a+' '+b;
        if(memo.containsKey(key)) return memo.get(key);
        boolean ans=false;
        int n=a.length();
        for(int i=1; i<n; i++){
            boolean swap=helper(a.substring(0,i),b.substring(n-i)) && helper(a.substring(i),b.substring(0,n-i));
            if(swap){
                ans=true;
                break;
            }
            boolean noswap=helper(a.substring(0,i),b.substring(0,i)) && helper(a.substring(i),b.substring(i));
            if(noswap){
                ans=true;
                break;
            }
            
        }
        memo.put(key,ans);
        return ans;
    }
}
