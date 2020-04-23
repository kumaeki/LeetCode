package kuma.p00.lc0006_ZigZag_Conversion;

class Solution {
    // Runtime: 2 ms, faster than 99.95% of Java online submissions for ZigZag
    // Conversion.
    // Memory Usage: 39.5 MB, less than 65.96% of Java online submissions for ZigZag
    // Conversion.
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows < 2 || numRows >= n)
            return s;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int index = i, k1 = 2 * (numRows - 1 - i), k2 = 2 * i;
            while (index < n) {
                if (index < n && k1 != 0) {
                    sb.append(s.charAt(index));
                    index = index + k1;
                }
                if (index < n && k2 != 0) {
                    sb.append(s.charAt(index));
                    index = index + k2;
                }
            }
        }
        return sb.toString();
    }
}