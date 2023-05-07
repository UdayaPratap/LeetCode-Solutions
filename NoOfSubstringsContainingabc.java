/*
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 */
class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map=new HashMap<>();
        int start=0, end=0, n=s.length(), ans=0;
        //expand window till a,b,c are found. total valid substrings=n-end, add this to answer. then move start forward one by one and repeat process of adding new valid substrings until either of a b or c is not there.
        while(end<n){
            char c=s.charAt(end);
            map.put(c, map.getOrDefault(c, 0)+1);
            while(map.getOrDefault('a', 0) > 0
                    && map.getOrDefault('b', 0) > 0
                    && map.getOrDefault('c', 0) > 0){
                ans+=n-end;
                c=s.charAt(start);
                map.put(c, map.get(c)-1);
                start++;
            }
            end++;
        }
        return ans;
    }
}
