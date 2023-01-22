/*
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.
*/
class Solution {
   
   public int countSubstrings(String s) {
        int count = s.length();//min no of palindromic substrings is n
        for(int g = 1; g < s.length(); g++){ //g is the lengt of substrings being checked
            for(int i = 0; i + g < s.length(); i++){ // i is the starting index of current substring 
                int counter = isPal(s.substring(i,i+g+1))==true? 1: -1;
                if(counter > 0){
                    count += counter;
                }
            }
        }
        return count;
    }
    HashMap <String, Boolean> map=new HashMap<>();
    boolean isPal(String s)
    {
        if(map.containsKey(s))
            return map.get(s);
        int i=0; int j=s.length()-1;
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
                {
                    map.put(s,false);
                    return false;
                }
            i++;
            j--;
        }
        map.put(s,true);
        return true;
    }
}
