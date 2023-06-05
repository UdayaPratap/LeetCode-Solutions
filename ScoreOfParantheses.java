/*Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
*/
class Solution {
    public int scoreOfParentheses(String s) {
        int depth=0, n=s.length();
        int ans=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='(') depth++;
            else{
                depth--;
                if(s.charAt(i-1)=='(') ans+=Math.pow(2, depth);
            }
        }
        return ans;
    }
    // public int scoreOfParentheses(String s) {
    //     Stack<Character> st=new Stack<>();
    //     for(char c: s.toCharArray()){
    //         if(c=='(') st.push('(');
    //         else{
    //             if(st.peek()=='('){
    //                 st.pop();
    //                 st.push('1');
    //             }else{
    //                 int sum=0;
    //                 while(!st.isEmpty() && st.peek()!='(') sum+=st.pop()-'0';
    //                 st.pop();
    //                 st.push((char)(2*sum+'0'));
    //             }
    //         }
    //     }
    //     int sum=0;
    //     while(!st.isEmpty())sum+=(st.pop()-'0');
    //     return sum;
    // }
}
