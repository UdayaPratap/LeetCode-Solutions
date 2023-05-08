/*
You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order. Apply the following algorithm on arr:

Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.
Keep repeating the steps again, alternating left to right and right to left, until a single number remains.
Given the integer n, return the last number that remains in arr.
  */
class Solution {
    public int lastRemaining(int n) {
        int firstIdx=1;
        boolean toRight=true;
        int step=1;
        int rem=n;
        while(rem>1){
            if(toRight  || rem%2!=0){ //on observing it is found that firstIdx changes when going from L-R or when going R-L but elements left is odd
                 firstIdx+=step; //firstIdx changed
                
            }
            step=step<<1; //startIdx jumps by step in each complete iteration
            rem=rem>>1;   //half the elements are left in after each iteration
            toRight=!toRight;   //change direction of iteration
        }
        return firstIdx;
    }
}
