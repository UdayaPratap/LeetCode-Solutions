/*
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

In addition to the mapping above, an encoded message may contain the '*' character, which can represent any digit from '1' to '9' ('0' is excluded). For example, the encoded message "1*" may represent any of the encoded messages "11", "12", "13", "14", "15", "16", "17", "18", or "19". Decoding "1*" is equivalent to decoding any of the encoded messages it can represent.

Given a string s consisting of digits and '*' characters, return the number of ways to decode it.

Since the answer may be very large, return it modulo 109 + 7.
*/
class Solution {
    	private static final int MOD = 1000000007;
    public int numDecodings(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int n = str.length();
        int[] dp = new int[n + 1];
        // 1 way to decode empty string
        dp[0] = 1;
        dp[1] = ways1(str.charAt(0));
        for (int i = 2; i <= n; i++) {
            long oneCharWays = (long) ways1(str.charAt(i - 1)) * dp[i - 1];
            long twoCharWays = ways2(str.charAt(i - 2), str.charAt(i - 1)) * dp[i - 2];
            dp[i] = (int) ((oneCharWays + twoCharWays) % MOD);
        }
        return dp[n];
    }
    int ways1(char curr) {
        if (curr == '*') {
            return 9;
        } else if (curr != '0') {
            return 1;
        } else {
            return 0;
        }
    }
   long ways2(char curr, char prev) {
        if (curr == '*' && prev == '*') {
            // pattern '**'
            return 15;
        } else if (curr == '*') {
            // pattern '*D'
            return prev > '6' ? 1 : 2;
        } else if (prev == '*') {
            // pattern 'D*'
            return (curr == '1') ? 9 : (curr == '2') ? 6 : 0;
        } else {
            // pattern 'DD'
            int val = Integer.parseInt("" + curr + prev);
            return val >= 10 && val <= 26 ? 1 : 0;
        }
    }
}
