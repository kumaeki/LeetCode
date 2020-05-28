package kuma.p03.lc0316_Remove_Duplicate_Letters;

import java.util.*;

public class Solution {
    // Runtime: 2 ms, faster than 92.37% of Java online submissions for Remove
    // Duplicate Letters.
    // Memory Usage: 39.9 MB, less than 16.67% of Java online submissions for Remove
    // Duplicate Letters.
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        int[] counts = new int[26], isContained = new int[26];
        for (char c : s.toCharArray())
            counts[c - 'a']++;

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            counts[index]--;
            if (isContained[index] == 1)
                continue;

            while (!stack.isEmpty() && stack.peek() > c && counts[stack.peek() - 'a'] > 0)
                isContained[stack.pop() - 'a'] = 0;

            stack.push(c);
            isContained[index] = 1;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
