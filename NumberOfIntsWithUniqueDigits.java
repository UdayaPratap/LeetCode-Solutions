/*
Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.
*/
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
        int ans=10; // uniques for n==1
        int temp=9;
        for(int i=2;i<=n;i++)
        {
            temp=temp*(9-i+2); //no of uniques for i length
            ans+=temp;
        }
       return ans;
    }
}
