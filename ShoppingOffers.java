/*
In LeetCode Store, there are n items to sell. Each item has a price. However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

You are given an integer array price where price[i] is the price of the ith item, and an integer array needs where needs[i] is the number of pieces of the ith item you want to buy.

You are also given an array special where special[i] is of size n + 1 where special[i][j] is the number of pieces of the jth item in the ith offer and special[i][n] (i.e., the last integer in the array) is the price of the ith offer.

Return the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers. You are not allowed to buy more items than you want, even if that would lower the overall price. You could use any of the special offers as many times as you want.

 */
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return helper(price, special, needs, 0);
    }
    int helper(List<Integer> prices, List<List<Integer>> special, List<Integer> needs, int idx)
    {
        int minPrice=noOffers(prices, needs);
        for(int i=idx;i<special.size();i++)
        {
            List<Integer> offer=special.get(i);
            List<Integer> newNeeds=new ArrayList<>();
            for(int j=0;j<needs.size();j++)
            {
                if(needs.get(j)<offer.get(j)){
                    newNeeds=null;
                    break;
                }
                newNeeds.add(needs.get(j)-offer.get(j));
            }//if offer valid then new needs contains qty needed after applying offer.
            if(newNeeds!=null){
                minPrice=Math.min(minPrice, offer.get(offer.size()-1)+helper(prices, special, newNeeds, i)); //choose min from offer and no offer
            }

        }
        return minPrice;
    }
    int noOffers(List<Integer> price, List<Integer> needs)
    {
        int total=0;
        for(int i=0;i<price.size();i++)
        {
            total+=price.get(i)*needs.get(i);
        }
        return total;
    }
}
