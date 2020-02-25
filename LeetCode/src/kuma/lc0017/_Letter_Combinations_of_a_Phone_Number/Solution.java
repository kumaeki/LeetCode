package kuma.lc0017._Letter_Combinations_of_a_Phone_Number;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Solution {
    static Map<Character, char[]> map = new HashMap<Character, char[]>();
    static {
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v' });
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
    }

    public List<String> letterCombinations(String digits) {
        List<String> reslist = new ArrayList<String>();
        if (digits == null || digits.isEmpty())
            return reslist;

        for (char c : map.get(digits.charAt(0))) {
            List<String> list = letterCombinations(digits.substring(1));
            if (list.size() == 0)
                reslist.add(String.valueOf(c));
            else {
                for (String s : list)
                    reslist.add(String.valueOf(c) + s);
            }
        }
        return reslist;
    }

    @Test
    public void testSimple1() {
        String[] expecteds = new String[] { "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf" };
        List<String> list = new Solution().letterCombinations("23");
        String[] actuals = list.toArray(new String[list.size()]);
        assertArrayEquals(expecteds, actuals);
    }

}
