package kuma.p02.lc0273_Integer_to_English_Words;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution2 {

    static Map<Integer, String> map;
    static int[] arr;
    static {
        arr = new int[] { 0, 1_000, 1_000_000, 1_000_000_000 };
        map = new HashMap<Integer, String>();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "Hundred");
        map.put(1_000, "Thousand");
        map.put(1_000_000, "Million");
        map.put(1_000_000_000, "Billion");
    }

    // Runtime: 2 ms, faster than 94.81% of Java online submissions for Integer to
    // English Words.
    // Memory Usage: 37.7 MB, less than 6.38% of Java online submissions for Integer
    // to English Words.
    public String numberToWords(int num) {
        if (num == 0)
            return map.get(num);
        StringBuilder sb = new StringBuilder();
        int billion = num / 1_000_000_000;
        int million = (num % 1_000_000_000) / 1_000_000;
        int thousand = (num % 1_000_000) / 1_000;
        int rest = num % 1_000;
        if (billion > 0)
            sb.append(convert(billion)).append(" ").append(map.get(1_000_000_000)).append(" ");
        if (million > 0)
            sb.append(convert(million)).append(" ").append(map.get(1_000_000)).append(" ");
        if (thousand > 0)
            sb.append(convert(thousand)).append(" ").append(map.get(1_000)).append(" ");
        if (rest > 0)
            sb.append(convert(rest)).append(" ");

        return sb.toString().trim();
    }

    private String convert(int num) {
        StringBuilder sb = new StringBuilder();
        if (num > 0) {
            int hundred = (num % 1_000) / 100;
            int ten = num % 100;
            if (hundred > 0) {
                sb.append(map.get(hundred)).append(" ").append(map.get(100)).append(" ");
            }
            if (ten > 0)
                if (map.containsKey(ten)) {
                    sb.append(map.get(ten)).append(" ");
                } else {
                    sb.append(map.get(ten - ten % 10)).append(" ");
                    sb.append(map.get(ten % 10)).append(" ");
                }
        }
        return sb.toString().trim();
    }

    @Test
    public void simple1() {
        assertEquals("One Hundred Twenty Three", new Solution2().numberToWords(123));
    }

    @Test
    public void simple2() {
        assertEquals("One Hundred", new Solution2().numberToWords(100));
    }
}
