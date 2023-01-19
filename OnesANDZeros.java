/*
You are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.
*/
class Solution {
    
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] memo=new int[m+1][n+1][strs.length+1];
        return knapsack(strs,m,n,0,memo);
    }
    int knapsack(String[] strs, int m , int n, int i,int memo[][][])
    {
        if(i>strs.length-1)
            return 0;
        if((m<0 || n<0) || (m==0 && n==0))
            return 0;
        if(memo[m][n][i]!=0)
            return memo[m][n][i];
        String curr=strs[i];
        int zeros=countZeros(curr);
        int ones=curr.length()-zeros;
        if(zeros<=m && ones<=n){
            int temp=Math.max(1+knapsack(strs,m-zeros,n-ones,i+1,memo), knapsack(strs,m,n,i+1,memo));
            memo[m][n][i]=temp;
            return temp;
        }
        int temp=knapsack(strs,m,n,i+1,memo);
        memo[m][n][i]=temp;
        return temp;
    }
    int countZeros(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='0')
                count++;
        
        return count;
    }
}
