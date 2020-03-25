package kuma.p03.lc0394_Decode_String;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import java.util.*;

public class Solution {

    public String decodeString(String s) {
        Stack<String> stackstr = new Stack<String>();
        Stack<Integer> stackcount = new Stack<Integer>();
        String str = "";
        String count = "";

        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                str += c;
            } else if (c >= '0' && c <= '9') {
                count += c;
            } else if (c == '[') {
                stackstr.push(str);
                str = "";
                stackcount.push(Integer.valueOf(count));
                count = "";
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                for (int i = stackcount.pop(); i > 0; i--)
                    sb.append(str);
                str = stackstr.pop() + sb.toString();
            }
        }
        return str;
    }

    @Test
    public void simple1() {
        String expected = "aaabcbc";
        String s = "3[a]2[bc]";
        String actual = new Solution().decodeString(s);
        assertEquals(expected, actual);
    }

}
