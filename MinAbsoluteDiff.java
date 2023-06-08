/*
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr
*/
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff=Integer.MAX_VALUE;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1; i<arr.length; i++){
            int diff=arr[i]-arr[i-1];
            if(diff==minDiff) ans.add(new ArrayList<>(Arrays.asList(arr[i-1], arr[i])));
            else if(diff<minDiff){
                ans.clear();
                ans.add(new ArrayList<>(Arrays.asList(arr[i-1], arr[i])));
                minDiff=diff;
            }
        }
        return ans;
    }
}
