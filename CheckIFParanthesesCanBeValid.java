/*
A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:

It is ().
It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
It can be written as (A), where A is a valid parentheses string.
You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked,

If locked[i] is '1', you cannot change s[i].
But if locked[i] is '0', you can change s[i] to either '(' or ')'.
Return true if you can make s a valid parentheses string. Otherwise, return false.
*/
class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2!=0) return false;
       int unlocked=0;
       int lockedClose=0;
       //l-to-r if no. of unlocked brackets<closed and locked brackets at any index then invalid
       for(int i=0; i<s.length(); i++)
       {
           if(locked.charAt(i)=='0' || s.charAt(i)=='(') unlocked++;
           else lockedClose++;
           if(unlocked<lockedClose) return false;
       }
       unlocked=0;
       int lockedOpen=0;
       //r-to-l if no. of unlocked brackets<open and locked brackets at any index then invalid
       for(int i=s.length()-1; i>=0; i--)
       {
           if(locked.charAt(i)=='0' || s.charAt(i)==')') unlocked++;
           else lockedOpen++;
           if(unlocked<lockedOpen) return false;
       }
       return true;
    }
}
