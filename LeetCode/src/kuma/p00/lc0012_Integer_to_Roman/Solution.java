package kuma.p00.lc0012_Integer_to_Roman;

class Solution {
    // Runtime: 4 ms, faster than 91.78% of Java online submissions for Integer to
    // Roman.
    // Memory Usage: 39.1 MB, less than 22.50% of Java online submissions for
    // Integer to Roman.
    public String intToRoman(int num) {
        int[] arrV = new int[] { 1, 5, 10, 50, 100, 500, 1000 };
        char[] arrS = new char[] { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        StringBuilder sb = new StringBuilder();
        for (int i = 6; i >= 0; i -= 2) {
            int val = arrV[i];
            int k = num / val;
            if (k == 4) {
                sb.append(arrS[i]).append(arrS[i + 1]);
            } else if (k == 9) {
                sb.append(arrS[i]).append(arrS[i + 2]);
            } else {
                if (k >= 5) {
                    sb.append(arrS[i + 1]);
                    k -= 5;
                }
                while (k-- > 0)
                    sb.append(arrS[i]);
            }
            num %= val;
        }
        return sb.toString();
    }
}
