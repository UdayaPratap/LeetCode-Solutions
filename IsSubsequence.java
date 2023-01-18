/*Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 */
class Solution {
    public boolean isSubsequence(String s, String t) {
		// int m = s.length();
		// int n = t.length();
		boolean[][] mem = new boolean[s.length() + 1][t.length() + 1];
		return check(s, t, 0, 0, mem);
	}

	boolean check(String s, String t, int m, int n, boolean[][] mem) {
		if (m != s.length() && n >= t.length())
			return false;
		else if (m >=s.length())
			return true;
		if (mem[m][n]) {
			return mem[m][n];
		}
		boolean isSubs = false;
		if (s.charAt(m) == t.charAt(n)) {
			isSubs = check(s, t, m + 1, n + 1, mem);
		} else {
			isSubs = check(s, t, m, n + 1, mem);
		}
		mem[m][n] = isSubs;
		return isSubs;
	}
}
