/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.
*/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> S= new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='#' && !S.isEmpty()) S.pop();
            else if(c!='#') S.push(c);
        }
        Stack<Character> T= new Stack<>();
        for(char c: t.toCharArray()){
            if(c=='#' && !T.isEmpty()) T.pop();
            else if(c!='#') T.push(c);
        }
        if(S.size()!=T.size()) return false;
        while(!S.isEmpty() && !T.isEmpty()){
            if(S.pop()!=T.pop()) return false;
        }
        return true;
    }
}
