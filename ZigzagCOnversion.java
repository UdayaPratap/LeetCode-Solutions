/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows
*/
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        
        char[] str=s.toCharArray();
        int n=s.length();
        char[] ans=new char[n];

        int jump1=2*(numRows-1);
        int jump2=0;
        int jump=jump1;
        int maxJump=jump1;
        int idx=0;
        for(int i=0; i<numRows; i++)
        {
            for(int j=i; j<n && idx<n; j+=jump)
            {
                ans[idx]=str[j];
                idx++;
                if(jump1==maxJump || jump2==maxJump) jump=maxJump;
                else if(jump==jump1) jump=jump2;
                else jump=jump1;

            }

            jump1-=2;
            jump2+=2;
            jump=jump2;
        }
        return String.valueOf(ans);
    }
}
