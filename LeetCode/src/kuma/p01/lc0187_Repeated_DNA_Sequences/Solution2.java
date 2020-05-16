package kuma.p01.lc0187_Repeated_DNA_Sequences;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution2 {
    // Runtime: 14 ms, faster than 92.83% of Java online submissions for Repeated
    // DNA Sequences.
    // Memory Usage: 48.3 MB, less than 54.84% of Java online submissions for
    // Repeated DNA Sequences.
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<String>(), res = new HashSet<String>();
        int n = s.length();
        for (int i = 0; i <= n - 10; i++) {
            String str = s.substring(i, i + 10);
            if (!set.add(str))
                res.add(str);
        }
        return new ArrayList<String>(res);
    }

    @Test
    public void simple1() {
        String[] expecteds = new String[] { "AAAAACCCCC", "CCCCCAAAAA" };
        String[] actuals = new Solution2().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")
                .toArray(new String[2]);
        assertArrayEquals(expecteds, actuals);
    }
}
