/*
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.

 */
class Solution {
    public int compress(char[] chars) {
        char prev = chars[0];
        int count = 0;
        int len = 0;
        int idx = 0;
        for(char ch : chars){
            if(prev == ch){
                count++;
            }
            else{
                if(count == 1){
                    len++;
                    chars[idx++] = prev;
                }
                else{
                    len++;
                    chars[idx++] = prev;
                    String tmp = Integer.toString(count);
                    len+=tmp.length();
                    for(char tc : tmp.toCharArray()) chars[idx++] = tc;
                    
                }
                prev = ch;
                count = 1;
            }
        }
        if(count == 1){
            len++;
            chars[idx++] = prev;
        }
        else{
            len++;
            chars[idx++] = prev;
            String tmp = Integer.toString(count);
            len+=tmp.length();
            for(char tc : tmp.toCharArray()) chars[idx++] = tc;
            
        }
        return len;
    }
}
