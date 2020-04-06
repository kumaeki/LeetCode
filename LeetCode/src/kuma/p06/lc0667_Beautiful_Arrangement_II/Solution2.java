package kuma.p06.lc0667_Beautiful_Arrangement_II;

public class Solution2 {
    // Runtime: 1 ms, faster than 51.84% of Java online submissions for Beautiful
    // Arrangement II.
    // Memory Usage: 41.7 MB, less than 25.00% of Java online submissions for
    // Beautiful Arrangement II.
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (k == 1) {
                res[index++] = i;
            } else {
                int left = i, right = Math.min(i + k, n);
                while (left < right) {
                    res[index++] = left++;
                    res[index++] = right--;
                }
                if (left == right)
                    res[index++] = left;
                i += k;
                k = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.constructArray(3, 2);
        s.constructArray(3, 1);
        s.constructArray(10, 4);
    }
}
