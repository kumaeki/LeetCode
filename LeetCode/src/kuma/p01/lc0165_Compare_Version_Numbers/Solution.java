package kuma.p01.lc0165_Compare_Version_Numbers;

public class Solution {
    // Runtime: 1 ms, faster than 88.59% of Java online submissions for Compare
    // Version Numbers.
    // Memory Usage: 37.6 MB, less than 6.00% of Java online submissions for Compare
    // Version Numbers.
    public int compareVersion(String version1, String version2) {
        if (version1.length() < version2.length())
            return -compareVersion(version2, version1);
        String[] arr1 = version1.split("\\."), arr2 = version2.split("\\.");
        for (int i = 0, n = arr1.length; i < n; i++) {
            int v1 = Integer.valueOf(arr1[i]);
            if (i >= arr2.length) {
                if (v1 != 0)
                    return 1;
                continue;
            }
            int v2 = Integer.valueOf(arr2[i]);
            // System.out.println(v1 + " : " + v2);
            if (v1 > v2)
                return 1;
            if (v1 < v2)
                return -1;
        }
        return 0;
    }
}
