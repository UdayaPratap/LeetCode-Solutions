/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
*/
class Solution {
    public int reverse(int x) {
        boolean pos=true;
        if(x<0)
        {
            pos=false;
            x=x * -1;
        }
        int ans=0;
            while(x>0)
            {
                if(ans>Integer.MAX_VALUE/10){
                    return 0;
                }
                ans=ans*10+x%10;
                x/=10;
            }
        if(!pos)
            return (-1)*ans;
        return ans;    
    }
}
