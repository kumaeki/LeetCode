package kuma.p01.lc0165_Compare_Version_Numbers;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Compare
    // Version Numbers.
    // Memory Usage: 37.4 MB, less than 6.00% of Java online submissions for Compare
    // Version Numbers.
    public int compareVersion(String version1, String version2) {
        int n1 = version1.length(), n2 = version2.length();
        if (n1 < n2)
            return -compareVersion(version2, version1);
        int left1 = 0, right1 = 0, left2 = 0, right2 = 0;
        while (left1 < n1) {
            while (right1 < n1 && version1.charAt(right1) != '.')
                right1++;
            int v1 = 0;
            if (right1 <= n1)
                v1 = Integer.valueOf(version1.substring(left1, right1));

            while (right2 < n2 && version2.charAt(right2) != '.')
                right2++;
            int v2 = 0;
            if (right2 <= n2)
                v2 = Integer.valueOf(version2.substring(left2, right2));

            if (v1 > v2)
                return 1;
            if (v1 < v2)
                return -1;

            left1 = ++right1;
            left2 = ++right2;
        }

        return 0;
    }
}
