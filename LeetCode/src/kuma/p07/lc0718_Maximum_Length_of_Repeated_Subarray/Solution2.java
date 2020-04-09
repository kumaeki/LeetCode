package kuma.p07.lc0718_Maximum_Length_of_Repeated_Subarray;

public class Solution2 {
    // Runtime: 36 ms, faster than 95.80% of Java online submissions for Maximum
    // Length of Repeated Subarray.
    // Memory Usage: 39.1 MB, less than 95.00% of Java online submissions for
    // Maximum Length of Repeated Subarray.
    public int findLength(int[] A, int[] B) {
        int lena = A.length, lenb = B.length;
        int res = 0, sum, nexta, nextb;
        for (int j = 0; j < lenb; j++) {
            nexta = 0;
            nextb = lenb - 1 - j;
            sum = 0;
            while (nexta < lena && nextb < lenb)
                if (A[nexta++] == B[nextb++])
                    res = Math.max(res, ++sum);
                else
                    sum = 0;
        }
        for (int i = 0; i < lena; i++) {
            nexta = i;
            nextb = 0;
            sum = 0;
            while (nexta < lena && nextb < lenb)
                if (A[nexta++] == B[nextb++])
                    res = Math.max(res, ++sum);
                else
                    sum = 0;
        }
        return res;
    }
}
