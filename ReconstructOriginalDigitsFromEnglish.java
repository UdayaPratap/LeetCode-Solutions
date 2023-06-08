/*
Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending order.
*/
class Solution {
//  We can observe that some characters are only present in some words only like :
//  z(zero) -> 0
//  x(six)  -> 6
//  u(four) -> 4
//  w(two)  -> 2
//  g(eigth)-> 8
//  f(five+four) -> 5 && 4
//  O(one +two + four + zero) -> 1 && 2 && 4 && 0
//  t(three + eight + two) -> 3 && 8 && 2
//  s(seven + six) -> 7 && 6
//  i(nine + five + six + eight) -> 9 && 5 && 6 && 8
    Map<Integer, String> lookup;
    public String originalDigits(String s) {
        Map<Character, Integer> map=new HashMap<>();
        for(char c: s.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        int[] digits=new int[10];
        digits[0]=map.getOrDefault('z', 0);
        digits[6]=map.getOrDefault('x', 0);
        digits[4]=map.getOrDefault('u', 0);
        digits[2]=map.getOrDefault('w', 0);
        digits[8]=map.getOrDefault('g', 0);
        digits[5]=map.getOrDefault('f', 0)-digits[4];
        digits[1]=map.getOrDefault('o', 0)-digits[0]-digits[2]-digits[4];
        digits[3]=map.getOrDefault('t', 0)-digits[8]-digits[2];
        digits[7]=map.getOrDefault('s', 0)-digits[6];
        digits[9]=map.getOrDefault('i', 0)-digits[5]-digits[6]-digits[8];
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<10;i++){
            int freq=digits[i];
            while(freq-->0) sb.append(i);
        }
        return sb.toString();
        
    }

    Map<Integer, String> genLookup(){
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        return map;
    }
}
