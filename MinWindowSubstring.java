/*
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.
*/
class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c: t.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);
        int i=0, j=0;
        int minWindow=Integer.MAX_VALUE, minI=0;
        int n=s.length();
        int charsLeft=t.length();
        while(j<n){
            
            //expanding window
            char c=s.charAt(j);
            if(map.getOrDefault(c,0)>0) charsLeft--;
            map.put(c, map.getOrDefault(c,0)-1);
            j++;
            //shrinking window
            while(charsLeft==0){
                if(minWindow>j-i){
                    minWindow=j-i;
                    minI=i;
                }
                char c2=s.charAt(i);
                map.put(c2, map.getOrDefault(c2,0)+1);
                if(map.get(c2)>0) charsLeft++;
                i++;
            }
        }
        return minWindow==Integer.MAX_VALUE? "": s.substring(minI, minI+minWindow);

    }
}
