package kuma.p01.lc0187_Repeated_DNA_Sequences;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution4 {
    // Runtime: 4 ms, faster than 99.85% of Java online submissions for Repeated DNA
    // Sequences.
    // Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for
    // Repeated DNA Sequences.
    public List<String> findRepeatedDnaSequences(String s) {
        byte[] counts = new byte[0xfffff];
        List<String> res = new ArrayList<String>();
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int n = s.length(), code = 0;
        for (int i = 0; i < n; i++) {
            code = ((code << 2) & 0xfffff) | map[s.charAt(i) - 'A'];
            if (i >= 9) {
                if (counts[code] == 0)
                    counts[code] = 1;
                else if (counts[code] == 1) {
                    res.add(s.substring(i - 9, i + 1));
                    counts[code] = 2;
                }
            }
        }
        return res;
    }

    @Test
    public void simple1() {
        String[] expecteds = new String[] { "AAAAACCCCC", "CCCCCAAAAA" };
        String[] actuals = new Solution4().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")
                .toArray(new String[2]);
        assertArrayEquals(expecteds, actuals);
    }
}
