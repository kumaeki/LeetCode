package kuma.p08.lc0825_Friends_Of_Appropriate_Ages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Solution {
    // Runtime: 52 ms, faster than 7.11% of Java online submissions for Friends Of
    // Appropriate Ages.
    // Memory Usage: 41.6 MB, less than 20.00% of Java online submissions for
    // Friends Of Appropriate Ages.
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res = 0, len = ages.length;
        for (int i = len - 1; i >= 0; i--) {
            int left = 0, right = i - 1;
            int target = ages[i] / 2 + 7;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (ages[mid] <= target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            res += (i - left);
            if (target < ages[i]) {
                left = i + 1;
                right = len - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (ages[mid] == ages[i])
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
                res += (right - i);
            }
        }
        return res;
    }

    @Test
    public void simple1() {
        assertEquals(2, new Solution().numFriendRequests(new int[] { 16, 16 }));
    }

    @Test
    public void simple2() {
        assertEquals(29, new Solution()
                .numFriendRequests(new int[] { 73, 106, 39, 6, 26, 15, 30, 100, 71, 35, 46, 112, 6, 60, 110 }));
    }
}
