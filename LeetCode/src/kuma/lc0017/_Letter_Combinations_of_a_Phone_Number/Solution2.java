package kuma.lc0017._Letter_Combinations_of_a_Phone_Number;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Solution2 {

    public List<String> letterCombinations(String digits) {
        List<String> reslist = new ArrayList<String>();
        if (digits == null || digits.isEmpty())
            return reslist;
        if (digits.length() == 1)
            return helper(digits.charAt(0));

        for (String s : helper(digits.charAt(0)))
            for (String str : letterCombinations(digits.substring(1)))
                reslist.add(s + str);

        return reslist;
    }

    private static List<String> helper(char c) {
        switch (c) {
        case '2':
            return new ArrayList<String>(Arrays.asList(new String[] { "a", "b", "c" }));
        case '3':
            return new ArrayList<String>(Arrays.asList(new String[] { "d", "e", "f" }));
        case '4':
            return new ArrayList<String>(Arrays.asList(new String[] { "g", "h", "i" }));
        case '5':
            return new ArrayList<String>(Arrays.asList(new String[] { "j", "k", "l" }));
        case '6':
            return new ArrayList<String>(Arrays.asList(new String[] { "m", "n", "o" }));
        case '7':
            return new ArrayList<String>(Arrays.asList(new String[] { "p", "q", "r", "s" }));
        case '8':
            return new ArrayList<String>(Arrays.asList(new String[] { "t", "u", "v" }));
        case '9':
            return new ArrayList<String>(Arrays.asList(new String[] { "w", "x", "y", "z" }));
        default:
            return null;
        }
    }

    @Test
    public void testSimple1() {
        String[] expecteds = new String[] { "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf" };
        List<String> list = new Solution2().letterCombinations("23");
        String[] actuals = list.toArray(new String[list.size()]);
        assertArrayEquals(expecteds, actuals);
    }

}
