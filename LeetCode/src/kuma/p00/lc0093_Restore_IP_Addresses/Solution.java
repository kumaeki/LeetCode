package kuma.p00.lc0093_Restore_IP_Addresses;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

public class Solution {
    // Runtime: 1 ms, faster than 99.60% of Java online submissions for Restore IP
    // Addresses.
    // Memory Usage: 39.4 MB, less than 6.98% of Java online submissions for Restore
    // IP Addresses.
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        helper(res, new String[4], s, 0, 0);
        return res;
    }

    private void helper(List<String> res, String[] cans, String s, int index, int count) {
        if (index == s.length()) {
            if (count != 4)
                return;
            StringBuilder sb = new StringBuilder();
            sb.append(cans[0]).append(".").append(cans[1]).append(".").append(cans[2]).append(".").append(cans[3]);
            res.add(sb.toString());
        } else {
            if (count == 4)
                return;
            for (int i = 1; i < 4 && index + i <= s.length(); i++) {
                if (s.charAt(index) == '0' && i > 1)
                    continue;
                String can = s.substring(index, index + i);
                if (Integer.valueOf(can) > 255)
                    continue;
                String temp = cans[count];
                cans[count] = can;
                helper(res, cans, s, index + i, count + 1);
                cans[count] = temp;
            }
        }
    }

    @Test
    public void simple1() {
        String[] expecteds = new String[] { "255.255.11.135", "255.255.111.35" };
        String[] actuals = new Solution().restoreIpAddresses("25525511135").toArray(new String[2]);
        assertArrayEquals(expecteds, actuals);
    }
}
