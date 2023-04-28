/*
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
substring
.
*/
class Solution {
    public int longestValidParentheses(String s) {
      Stack<Integer> st=new Stack<>();
      st.push(-1); //stack shudnt be empty
      int max=0;
      for(int i=0;i<s.length();i++)
      {
          char c=s.charAt(i);
          if(c=='(') st.push(i);
          else if(c==')'){
              st.pop();
              if(st.isEmpty()){
                  st.push(i);
              }else{
                int len=i-st.peek(); //length of valid string ending at i
                max=Math.max(len, max);
              }
          }

      }   
      return max;
    }
}
