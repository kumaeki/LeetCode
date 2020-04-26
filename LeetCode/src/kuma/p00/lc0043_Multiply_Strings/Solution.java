package kuma.p00.lc0043_Multiply_Strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution {
    // Time limit Exceeded
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        StringBuilder sb = new StringBuilder("0");
        for (int i = len1 - 1; i >= 0; i--)
            for (int j = len2 - 1; j >= 0; j--) {
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int index = (len1 - 1 - i) + (len2 - 1 - j);
                add(sb, index, num);
            }
        for (int i = sb.length() - 1; i >= 1 && sb.charAt(i) == '0'; i--)
            sb.deleteCharAt(i);
        return sb.reverse().toString();
    }

    private void add(StringBuilder sb, int index, int num) {
        if (index < sb.length()) {
            int temp = sb.charAt(index) - '0' + num;
            sb.replace(index, index + 1, String.valueOf(temp % 10));
            add(sb, index + 1, temp / 10);
        } else {
            sb.append(num % 10);
            if (num / 10 != 0)
                sb.append(num / 10);
        }
    }

    @Test
    public void simple5() {
        assertEquals("3006", new Solution().multiply("501", "6"));
    }

    @Test
    public void simple1() {
        assertEquals("6", new Solution().multiply("2", "3"));
    }

    @Test
    public void simple2() {
        assertEquals("56088", new Solution().multiply("123", "456"));
    }

    @Test
    public void simple3() {
        assertEquals("0", new Solution().multiply("0", "1233"));
    }

    @Test
    public void simple4() {
        assertEquals("0", new Solution().multiply("12345", "0"));
    }
}
