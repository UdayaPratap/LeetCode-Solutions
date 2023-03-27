/*
A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
*/class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0; i<s.length(); i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        HashSet<Integer> set=new HashSet<>();
        int deletion=0;
        for(char c: map.keySet()){
            int freq=map.get(c);
            if(!set.contains(freq)){ //if curr freq is unique, then add
                set.add(freq);
            }
            else{ //not unique, delete till becomes unique
                while(freq>0 && set.contains(freq)){
                    freq--;
                    deletion++;
                }
                if(freq>0) set.add(freq);
            }
        }
        return deletion;
    }
}
