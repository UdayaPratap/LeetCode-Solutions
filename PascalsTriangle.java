/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        curr.add(1);
        ans.add(curr);
        int row=2;
        while(row<=numRows){
            curr=new ArrayList<>();
            List<Integer> prev=ans.get(row-2);
            curr.add(1);
            for(int i=1; i<row-1; i++){
                curr.add(prev.get(i-1)+prev.get(i));
            }
            curr.add(1);
            ans.add(curr);
            row++;
        }
        return ans;
    }
}
