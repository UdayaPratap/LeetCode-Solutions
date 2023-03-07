/*
An additive number is a string whose digits can form an additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits, return true if it is an additive number or false otherwise.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
*/
class Solution {
    public boolean isAdditiveNumber(String num) {
        
        return helper(num, 0, 0, 0, 0);
    }
    boolean helper(String num, int idx, long prev, long sum, int length)
    {
        if(idx == num.length()){
            return length >= 3;
        }
        if(idx==num.length()) return true;
        long curr=0;
        for(int i=idx; i<num.length(); i++)
        {
            if(num.charAt(idx)=='0' && i>idx) break;
            curr=curr*10 + (num.charAt(i)-'0');
            if(length>=2)
            {
                if(curr > sum) break;
                else if(curr< sum) continue;
            }
            if(helper(num, i+1, curr, curr+prev, length+1)) return true; 
        }
        return false;
    }

}
