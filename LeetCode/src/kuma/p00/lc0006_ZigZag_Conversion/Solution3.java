package kuma.p00.lc0006_ZigZag_Conversion;

class Solution3 {
    // Runtime: 2 ms, faster than 99.95% of Java online submissions for ZigZag
    // Conversion.
    // Memory Usage: 39.8 MB, less than 56.38% of Java online submissions for ZigZag
    // Conversion.
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows < 2 || numRows >= n)
            return s;

        int cycle = 2 * numRows - 2, index = 0;
        char[] res = new char[n];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycle) {
                res[index++] = s.charAt(i + j);
                if (i != 0 && i != numRows - 1 && j + cycle - i < n)
                    res[index++] = s.charAt(j + cycle - i);
            }
        }
        return new String(res);
    }
}