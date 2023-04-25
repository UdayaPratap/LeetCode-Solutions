/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
class Solution {
    public int strStr(String haystack, String needle) {
        int N=haystack.length(), n=needle.length();
        if(N==n && haystack.equals(needle)) return 0;
        for(int i=0; i<=N-n; i++)
        {   
            if(haystack.charAt(i)==needle.charAt(0))
                if(n>1 && haystack.substring(i, i+n).equals(needle)) return i;
                else if(n==1) return i;
        }
        return -1;
    }
}
