/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.
*/
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> st=new Stack<>(); //stores result string at various[] brackets
        Stack<Integer> key=new Stack<>(); //stores num values for various[] brakcets
        int n=s.length();
        int num=0;
        StringBuilder ans=new StringBuilder();
        for(char c: s.toCharArray()){
            //number
            if(c>='0' && c<='9')
                num=num*10+(c-'0');
            //[
            else if(c=='['){
                //store values till here in stack and do again considering new string inside []
                key.push(num);
                num=0;
                st.push(ans);
                ans=new StringBuilder();
            }
            //]
            else if(c==']')
            {
                StringBuilder temp=ans;
                ans=st.pop();
                int count=key.pop();
                while(count-->0)
                    ans.append(temp);
            }
            //character
            else
                ans.append(c);
        }
        return ans.toString();
    }
}
