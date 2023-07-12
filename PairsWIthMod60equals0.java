/*You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
  */
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < time.length; i++) {
            int rem = time[i] % 60;
            int complement = (60 - rem) % 60;
            count += map.getOrDefault(complement, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}
