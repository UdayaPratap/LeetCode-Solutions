/*
There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.

The operation of drinking a full water bottle turns it into an empty bottle.

Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.
*/
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int n=numBottles;
        int total=0;
        int empty=0;
        while(n!=0){
            
            total+=n; //drank
            empty+=n;
            
            if(empty%numExchange==0){
                 n=empty/numExchange;
                 empty=0;
            }
            else{
                int temp=empty;
                empty=temp%numExchange;
                n=temp/numExchange;
            }
        }
        return total;
    }
}
