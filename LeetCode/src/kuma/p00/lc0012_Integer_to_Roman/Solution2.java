package kuma.p00.lc0012_Integer_to_Roman;

class Solution2 {
    // Runtime: 3 ms, faster than 100.00% of Java online submissions for Integer to
    // Roman.
    // Memory Usage: 38.6 MB, less than 22.50% of Java online submissions for
    // Integer to Roman.
    public String intToRoman(int num) {
        int[] arrV = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] arrS = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
        StringBuilder sb = new StringBuilder();
        for (int i = arrS.length - 1; i >= 0 && num > 0; i--) {
            int val = arrV[i];
            String sym = arrS[i];
            while (num > val) {
                num -= val;
                sb.append(sym);
            }
        }
        return sb.toString();
    }
}
