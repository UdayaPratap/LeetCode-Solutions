/*
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.
  */
class Solution {
    public String largestNumber(int[] nums) {
    Integer[] nums2 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
     Arrays.sort(nums2, (a, b) -> {
    String order1=a+""+b;
    String order2=b+""+a;
    return order2.compareTo(order1);
});
     StringBuilder sb=new StringBuilder();
     for(int i=0; i<nums2.length; i++){
         sb.append(nums2[i]);
     }
     while(sb.charAt(0)=='0' && sb.length()>1)
    {
        sb.deleteCharAt(0);
    }
     return sb.toString();
    }
}
