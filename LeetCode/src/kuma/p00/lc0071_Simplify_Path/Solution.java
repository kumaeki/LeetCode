package kuma.p00.lc0071_Simplify_Path;

import java.util.LinkedList;

class Solution {
    // Runtime: 3 ms, faster than 97.32% of Java online submissions for Simplify
    // Path.
    // Memory Usage: 39 MB, less than 20.00% of Java online submissions for Simplify
    // Path.
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<String>();
        String[] arr = path.split("/");
        for (String str : arr) {
            if (str.equals(".") || str.isEmpty())
                continue;

            if (str.equals("..")) {
                if (!stack.isEmpty())
                    stack.removeLast();
            } else
                stack.addLast(str);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append("/").append(stack.removeFirst());

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
