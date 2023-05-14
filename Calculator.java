/*
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
*/
class Solution {
       public int calculate(String s) {
        int curr = 0;
        char op = '+';
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            
            //check for digit
            if(Character.isDigit(ch)){
                curr = (curr * 10) + (ch - '0');
            }
            
            //check for operator
            if(!Character.isDigit(ch) && ch != ' ' || i == len-1){
                if(op == '+'){
                    stack.push(curr);
                }else if(op == '-'){
                    stack.push(-curr);
                }else if(op == '*'){
                    stack.push(stack.pop()*curr);
                }else if(op == '/'){
                    stack.push(stack.pop()/curr);
                }
                curr = 0;
                op = ch;
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}
