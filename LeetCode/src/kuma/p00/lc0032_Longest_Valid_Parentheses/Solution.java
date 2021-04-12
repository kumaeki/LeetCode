package kuma.p00.lc0032_Longest_Valid_Parentheses;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) 
                    stack.push(i);
                else
                    res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }
}
