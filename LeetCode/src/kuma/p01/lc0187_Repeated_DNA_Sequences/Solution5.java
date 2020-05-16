package kuma.p01.lc0187_Repeated_DNA_Sequences;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution5 {
    // Runtime: 5 ms, faster than 99.51% of Java online submissions for Repeated DNA
    // Sequences.
    // Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for
    // Repeated DNA Sequences.
    public List<String> findRepeatedDnaSequences(String s) {
        BitSet counts = new BitSet(0xfffff);
        Set<String> res = new HashSet<String>();
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int n = s.length(), code = 0;
        for (int i = 0; i < n; i++) {
            code = ((code << 2) & 0xfffff) | map[s.charAt(i) - 'A'];
            if (i >= 9) {
                if (counts.get(code))
                    res.add(s.substring(i - 9, i + 1));
                else
                    counts.set(code);
            }
        }
        return new ArrayList<String>(res);
    }

    @Test
    public void simple1() {
        String[] expecteds = new String[] { "AAAAACCCCC", "CCCCCAAAAA" };
        String[] actuals = new Solution5().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")
                .toArray(new String[2]);
        assertArrayEquals(expecteds, actuals);
    }
}
