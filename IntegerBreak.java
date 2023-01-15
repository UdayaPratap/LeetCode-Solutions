/*
Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.

Return the maximum product you can get.
*/
class Solution {
    public int integerBreak(int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        return integerBreak(n, map);
    }
    
   
    public int integerBreak(int n,HashMap<Integer,Integer> map) {
        if(map.containsKey(n))
            return map.get(n);
        int maxProd=Integer.MIN_VALUE;
        if(n==1)
            return 1;
        
        for(int i=1;i<=n/2;i++)
        {
                maxProd = Math.max(maxProd, i * Math.max(n-i, integerBreak(n-i,map)));
        }
        map.put(n,maxProd);
        return maxProd;
    }
}
