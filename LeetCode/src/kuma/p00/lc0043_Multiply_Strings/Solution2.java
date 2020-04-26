package kuma.p00.lc0043_Multiply_Strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution2 {
    // Runtime: 9 ms, faster than 28.16% of Java online submissions for Multiply
    // Strings.
    // Memory Usage: 39.8 MB, less than 10.00% of Java online submissions for
    // Multiply Strings.
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int len1 = num1.length(), len2 = num2.length();
        char[] arr = new char[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--)
            for (int j = len2 - 1; j >= 0; j--) {
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int index = (len1 - 1 - i) + (len2 - 1 - j);
                add(arr, index, num);
            }
        return new StringBuilder(new String(arr).trim()).reverse().toString();
    }

    private void add(char[] arr, int index, int num) {
        if (arr[index] >= '0')
            num = arr[index] - '0' + num;
        arr[index] = (char) ('0' + (num % 10));
        if (num / 10 != 0)
            add(arr, index + 1, num / 10);
    }

    @Test
    public void simple5() {
        assertEquals("3006", new Solution2().multiply("501", "6"));
    }

    @Test
    public void simple1() {
        assertEquals("6", new Solution2().multiply("2", "3"));
    }

    @Test
    public void simple2() {
        assertEquals("56088", new Solution2().multiply("123", "456"));
    }

    @Test
    public void simple3() {
        assertEquals("0", new Solution2().multiply("0", "1233"));
    }

    @Test
    public void simple4() {
        assertEquals("0", new Solution2().multiply("12345", "0"));
    }
}
