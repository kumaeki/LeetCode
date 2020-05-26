package kuma.p03.lc0306_Additive_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Solution {
    // Runtime: 5 ms, faster than 17.83% of Java online submissions for Additive
    // Number.
    // Memory Usage: 39.5 MB, less than 14.29% of Java online submissions for
    // Additive Number.
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3)
            return false;
        return helper(num, 0, 1, 1);
    }

    private boolean helper(String num, int start, int i, int j) {
        if (num.charAt(start) == '0' && i > 1)
            return false;
        if (num.charAt(start + i) == '0' && j > 1)
            return false;

        String num1 = num.substring(start, start + i);
        String num2 = num.substring(start + i, start + i + j);
        String sum = getSum(num1, num2);
        int n = sum.length();
        if (start + i + j + n > num.length())
            return false;
        if (sum.equals(num.substring(start + i + j, start + i + j + n)))
            if (helper(num, start + i, j, n) || start + i + j + n == num.length())
                return true;

        return helper(num, start, i + 1, j) || helper(num, start, i, j + 1);

    }

    private String getSum(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        if (m > n)
            return getSum(num2, num1);

        int carry = 0;
        char[] arr = new char[n + 1];
        while (n > 0) {
            int sum = carry + num2.charAt(n - 1) - '0';
            if (m > 0)
                sum += num1.charAt(m - 1) - '0';
            if (sum < 10)
                arr[n] = (char) ('0' + sum);
            else
                arr[n] = (char) (sum % 10 + '0');
            carry = sum / 10;
            m--;
            n--;
        }
        if (carry != 0)
            arr[0] = (char) (carry + '0');

        return new String(arr).trim();
    }

    @Test
    public void simple1() {
        assertEquals(true, new Solution().isAdditiveNumber("112358"));
    }

    @Test
    public void simple2() {
        assertEquals(true, new Solution().isAdditiveNumber("199100199"));
    }

    @Test
    public void simple3() {
        assertEquals(false, new Solution().isAdditiveNumber("1"));
    }

    @Test
    public void simple4() {
        assertEquals(false, new Solution().isAdditiveNumber("199001200"));
    }
}
