/*Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression);
    }

    List<Integer> helper(String s) {
        if (memo.containsKey(s)) return memo.get(s);
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*') {
                String left = s.substring(0, i);
                String right = s.substring(i + 1);
                List<Integer> leftRet = helper(left);
                List<Integer> rightRet = helper(right);
                for (int l : leftRet) {
                    for (int r : rightRet) {
                        int c = 0;
                        switch (s.charAt(i)) {
                            case '+':
                                c = l + r;
                                break;
                            case '-':
                                c = l - r;
                                break;
                            case '*':
                                c = l * r;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) ret.add(Integer.valueOf(s));
        memo.put(s, ret);
        return ret;
    }
}
