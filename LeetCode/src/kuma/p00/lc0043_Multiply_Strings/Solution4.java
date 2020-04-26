package kuma.p00.lc0043_Multiply_Strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution4 {
    // Runtime: 2 ms, faster than 98.90% of Java online submissions for Multiply
    // Strings.
    // Memory Usage: 39.6 MB, less than 10.00% of Java online submissions for
    // Multiply Strings.
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int len1 = num1.length(), len2 = num2.length(), len = len1 + len2;
        int[] arrnum1 = new int[len1], arrnum2 = new int[len2], resnum = new int[len];
        for (int i = 0; i < len1; i++)
            arrnum1[i] = num1.charAt(i) - '0';
        for (int i = 0; i < len2; i++)
            arrnum2[i] = num2.charAt(i) - '0';

        for (int i = len1 - 1; i >= 0; i--)
            for (int j = len2 - 1; j >= 0; j--) {
                int num = arrnum1[i] * arrnum2[j];
                int index = (len1 - 1 - i) + (len2 - 1 - j);
                resnum[index] += num;
            }

        int next = 0;
        for (int i = 0; i < len; i++) {
            resnum[i] += next;
            if (resnum[i] > 9) {
                next = resnum[i] / 10;
                resnum[i] %= 10;
            } else
                next = 0;
        }

        char[] arr = new char[len];
        for (int i = 0; i < len; i++)
            arr[i] = (char) (resnum[i] + '0');
        if (arr[len - 1] == '0')
            arr[len - 1] = ' ';
        return new StringBuilder(new String(arr).trim()).reverse().toString();
    }

//    private void add(int[] resnum, int index, int num) {
//        num += resnum[index];
//        resnum[index] = num % 10;
//        if (num / 10 != 0)
//            add(resnum, index + 1, num / 10);
//    }

    @Test
    public void simple5() {
        assertEquals("3006", new Solution4().multiply("501", "6"));
    }

    @Test
    public void simple1() {
        assertEquals("6", new Solution4().multiply("2", "3"));
    }

    @Test
    public void simple2() {
        assertEquals("56088", new Solution4().multiply("123", "456"));
    }

    @Test
    public void simple3() {
        assertEquals("0", new Solution4().multiply("0", "1233"));
    }

    @Test
    public void simple4() {
        assertEquals("0", new Solution4().multiply("12345", "0"));
    }
}
