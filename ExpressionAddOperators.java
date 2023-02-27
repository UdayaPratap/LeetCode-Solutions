/*
Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.
*/
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        helper(0, "", 0, 0, num, target, ans);
        return ans;
    }
    void helper(int i, String curr, long valSoFar, long prev, String num, int target, List<String> ans){
        if(i == num.length()){
            if(valSoFar == target){
                ans.add(curr);
            }
            return;
        }
        for(int j = i; j < num.length(); j++){
            if(j > i && num.charAt(i) == '0'){
                // Leading zeros should be skip
                break;
            }
            Long currVal = Long.parseLong(num.substring(i, j + 1));
            if(i== 0){
                
                helper(j + 1, curr + currVal, currVal, currVal, num, target, ans);
            } else {
                helper(j + 1, curr + "+" + currVal, valSoFar + currVal, currVal, num, target, ans);
                helper(j + 1, curr + "-" + currVal, valSoFar - currVal, -currVal, num, target, ans);
                helper(j + 1, curr + "*" + currVal, valSoFar - prev + currVal * prev, prev * currVal, num, target, ans);
            }
        }
    }
}
