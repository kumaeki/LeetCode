package kuma.p00.lc0093_Restore_IP_Addresses;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution2 {
    // Runtime: 4 ms, faster than 65.60% of Java online submissions for Restore IP
    // Addresses.
    // Memory Usage: 39.6 MB, less than 6.98% of Java online submissions for Restore
    // IP Addresses.
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        helper(res, "", s, 0, 0);
        return res;
    }

    private void helper(List<String> res, String prefix, String s, int index, int count) {
        if (index == s.length()) {
            if (count != 4)
                return;
            res.add(prefix);
        } else {
            if (count == 4)
                return;
            for (int i = 1; i < 4 && index + i <= s.length(); i++) {
                if (s.charAt(index) == '0' && i > 1)
                    continue;
                String can = s.substring(index, index + i);
                if (Integer.valueOf(can) > 255)
                    continue;
                helper(res, prefix + "." + can, s, index + i, count + 1);
            }
        }
    }

    @Test
    public void simple1() {
        String[] expecteds = new String[] { "255.255.11.135", "255.255.111.35" };
        String[] actuals = new Solution2().restoreIpAddresses("25525511135").toArray(new String[2]);
        assertArrayEquals(expecteds, actuals);
    }
}
