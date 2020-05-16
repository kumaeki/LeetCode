package kuma.p01.lc0187_Repeated_DNA_Sequences;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution3 {
    // Runtime: 13 ms, faster than 95.97% of Java online submissions for Repeated
    // DNA Sequences.
    // Memory Usage: 44.8 MB, less than 67.74% of Java online submissions for
    // Repeated DNA Sequences.
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> firstSet = new HashSet<Integer>(), doubleSet = new HashSet<Integer>();
        List<String> res = new ArrayList<String>();
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int n = s.length();
        for (int i = 0; i <= n - 10; i++) {
            int code = 0;
            for (int j = i, l = i + 10; j < l; j++) {
                code <<= 2;
                code |= map[s.charAt(j) - 'A'];
            }
            if (!firstSet.add(code) && doubleSet.add(code)) {
                res.add(s.substring(i, i + 10));
            }
        }
        return res;
    }

    @Test
    public void simple1() {
        String[] expecteds = new String[] { "AAAAACCCCC", "CCCCCAAAAA" };
        String[] actuals = new Solution3().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")
                .toArray(new String[2]);
        assertArrayEquals(expecteds, actuals);
    }
}
