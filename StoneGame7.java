/*
Given an array arr of positive integers, consider all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree, respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node. It is guaranteed this sum fits into a 32-bit integer.

A node is a leaf if and only if it has zero children.
*/
class Solution {
    public int stoneGameVII(int[] stones) {
        int sum=0;
        Integer [][]dp=new Integer[stones.length][stones.length];
        for(int i=0;i<stones.length;i++){
            sum+=stones[i];
        }
        int ans=fn(0,stones.length-1,stones,1,sum,dp);
        return ans;
    }
    public int fn(int l,int h,int []stones,int st,int sum,Integer [][]dp){
        if(l==h){
            return 0;
        }
        
        if(dp[l][h]!=null){
            return dp[l][h];
        }
        
        if(st==1){
              int ans1=sum-stones[l]+fn(l+1,h,stones,0,sum-stones[l],dp);       //Player1's 
              int ans2=sum-stones[h]+fn(l,h-1,stones,0,sum-stones[h],dp);
              dp[l][h]=Math.max(ans1,ans2);
        }else{
             int ans3=-(sum-stones[l])+fn(l+1,h,stones,1,sum-stones[l],dp);      //Player2's
             int ans4=-(sum-stones[h])+fn(l,h-1,stones,1,sum-stones[h],dp);
            dp[l][h]=Math.min(ans3,ans4);
        }
        
        return dp[l][h];
    }
}
