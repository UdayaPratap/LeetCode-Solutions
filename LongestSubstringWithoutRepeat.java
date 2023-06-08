/*Given a string s, find the length of the longest 
substring
 without repeating characters.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0, right=0, n=s.length();
        Map<Character, Integer> map=new HashMap<>();
        char arr[]=s.toCharArray();
        int max=0;
        while(right<n){
            if(map.containsKey(arr[right])) left=Math.max(map.get(arr[right])+1, left);
            map.put(arr[right], right);
            max=Math.max(max, right-left+1);
            right++;

        }
        return max;
    }
}
