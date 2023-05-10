/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
*/
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '(')
                st.push(i);
            else if(c==')') {
                if(!st.isEmpty() && s.charAt(st.peek()) == '(')
                    st.pop();
                else st.push(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>(st);
        for(int i=0;i<s.length();i++)
            if(!set.contains(i))
                sb.append(s.charAt(i));
        
        return sb.toString();
    }
}
