package kuma.p06.lc0667_Beautiful_Arrangement_II;

public class Solution {
    // Runtime: 2 ms, faster than 9.19% of Java online submissions for Beautiful
    // Arrangement II.
    // Memory Usage: 41.8 MB, less than 25.00% of Java online submissions for
    // Beautiful Arrangement II.
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int index = 0;
        for (int i = 1; i <= n; i += (k + 1)) {
            int left = i, right = Math.min(i + k, n);
            while (left < right) {
                res[index++] = left++;
                res[index++] = right--;
            }
            if (left == right)
                res[index++] = left;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.constructArray(3, 2);
        s.constructArray(3, 1);
        s.constructArray(10, 4);
    }
}
