package kuma.p06.lc0667_Beautiful_Arrangement_II;

public class Solution3 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Beautiful
    // Arrangement II.
    // Memory Usage: 39.9 MB, less than 25.00% of Java online submissions for
    // Beautiful Arrangement II.
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int index = 0;

        int left = 1, right = 1 + k;
        while (left < right) {
            res[index++] = left++;
            res[index++] = right--;
        }
        if (left == right)
            res[index++] = left;

        for (int i = k + 2; i <= n; i++)
            res[i - 1] = i;

        return res;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        s.constructArray(3, 2);
        s.constructArray(3, 1);
        s.constructArray(10, 4);
    }
}
