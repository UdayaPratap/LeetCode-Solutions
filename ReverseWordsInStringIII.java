/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
*/
class Solution {
    public String reverseWords(String s) {
        String[] arr=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(String t: arr){
           char[] c=t.toCharArray();
           reverse(c);
           sb.append(c).append(" ");
        }
        return sb.toString().trim();
    }
    void reverse(char[] c){
        int i=0, j=c.length-1;
        while(i<=j){
            char temp=c[i];
            c[i++]=c[j];
            c[j--]=temp;
        }
    }
}
