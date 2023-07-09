/*
Given an integer n, find a sequence that satisfies all of the following:

The integer 1 occurs once in the sequence.
Each integer between 2 and n occurs twice in the sequence.
For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.
The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.

Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a solution.

A sequence a is lexicographically larger than a sequence b (of the same length) if in the first position where a and b differ, sequence a has a number greater than the corresponding number in b. For example, [0,1,9,0] is lexicographically larger than [0,1,5,6] because the first position they differ is at the third number, and 9 is greater than 5.*/
class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] curr=new int[2*n-1];
        boolean[] used=new boolean[n+1];
        helper(n, curr, used, 0);
        return curr;
    }
    boolean helper(int n, int[] curr, boolean[] used, int index){
        if(index==curr.length) return true;
        //if this location already filled, call for next
        if(curr[index]!=0) return helper(n, curr, used, index+1);

        for(int i=n; i>=1; i--){
            if(used[i]) continue;
            used[i]=true;
            curr[index]=i;
            if(i==1){
                if(helper(n, curr, used, index+1)) return true;
            }
            else if(index+i < curr.length && curr[index+i]==0){
                curr[i+index]=i;
                if(helper(n, curr, used, index+1)) return true;
                curr[i+index]=0;
            }
            curr[index]=0;
            used[i]=false;
        }
        return false;
    }
}
