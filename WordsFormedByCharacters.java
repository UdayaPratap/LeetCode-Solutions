/*
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.
*/
class Solution {
  public int countCharacters(String[] words, String chars) {
    int ans = 0;
    int[] count = new int[26];
    for (char c : chars.toCharArray())
      count[c - 'a']++;

    for (String t : words) {
      int[] tempCount = count.clone();
      for (char c : t.toCharArray())
        if (--tempCount[c - 'a'] < 0) {
          ans -= t.length();
          break;
        }
      ans += t.length();
    }

    return ans;
  }
}
