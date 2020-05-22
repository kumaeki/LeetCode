package kuma.p02.lc0273_Integer_to_English_Words;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution {

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

    // Runtime: 4 ms, faster than 80.48% of Java online submissions for Integer to
    // English Words.
    // Memory Usage: 37.2 MB, less than 6.38% of Java online submissions for Integer
    // to English Words.
    public String numberToWords(int num) {
        if (num == 0)
            return map.get(num);
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<String>();
        int index = 0;
        while (num > 0) {
            int cur = num % 1_000;
            if (cur > 0) {
                int ten = cur % 100;
                int hundred = (cur % 1_000) / 100;

                if (index > 0)
                    list.add(map.get(arr[index]));

                if (ten > 0)
                    if (map.containsKey(ten)) {
                        list.add(map.get(ten));
                    } else {
                        list.add(map.get(ten % 10));
                        list.add(map.get(ten - ten % 10));

                    }
                if (hundred > 0) {
                    list.add(map.get(100));
                    list.add(map.get(hundred));
                }
            }
            index++;
            num /= 1_000;
        }
        for (int i = list.size() - 1; i >= 0; i--)
            sb.append(list.get(i)).append(" ");
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    @Test
    public void simple1() {
        assertEquals("One Hundred Twenty Three", new Solution().numberToWords(123));
    }

    @Test
    public void simple2() {
        assertEquals("One Hundred", new Solution().numberToWords(100));
    }
}
